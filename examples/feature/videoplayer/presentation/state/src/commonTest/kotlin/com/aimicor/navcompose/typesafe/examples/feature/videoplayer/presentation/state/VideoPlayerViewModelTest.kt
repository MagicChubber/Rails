package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.state

import app.cash.turbine.test
import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.entity.SelectedVideo
import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.usecase.FetchSelectedVideoUseCase
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRailItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class VideoPlayerViewModelTest {

    private var selectedVideoResult: Result<SelectedVideo>? = null
    private val selectedVideoResultFlow = MutableSharedFlow<Result<SelectedVideo>>()

    private val fetchSelectedVideoUseCase = object : FetchSelectedVideoUseCase {
        override suspend fun invoke(
            video: VideoRailItem
        ): Result<SelectedVideo> = selectedVideoResultFlow.first()
    }

    private val videoItem = VideoRailItem(
        id = "1",
        title = "title",
        description = "description",
        imgUrl = "imgUrl"
    )

    private val playerInfo = VideoPlayerInfo(
        selectedVideoItem = videoItem,
        categoryList = listOf(videoItem)
    )

    private val sut by lazy {
        VideoPlayerViewModel(fetchSelectedVideoUseCase, playerInfo)
    }

    @Test
    fun `GIVEN selection WHEN first displayed THEN video selected is fetching`() = runTest {
        sut.uiState.test {

            assertEquals(VideoPlayerUIState.Fetching(playerInfo), awaitItem())
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun `GIVEN url fetch WHEN fail THEN video selected is error`() = runTest {
        sut.uiState.test {
            assertEquals(VideoPlayerUIState.Fetching(playerInfo), awaitItem())

            selectedVideoResultFlow.emit(Result.failure(Exception("error")))

            assertEquals(VideoPlayerUIState.Error(videoItem), awaitItem())
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun `GIVEN url fetch WHEN success THEN video selected is fetched`() = runTest {
        val videoUrl = "url"
        sut.uiState.test {
            assertEquals(VideoPlayerUIState.Fetching(playerInfo), awaitItem())

            selectedVideoResultFlow.emit(Result.success(SelectedVideo(videoUrl, videoItem)))

            assertEquals(VideoPlayerUIState.Fetched(videoUrl), awaitItem())
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun `GIVEN video playing WHEN new video selected THEN new url fetched`() = runTest {
        val videoUrl = "url"
        sut.uiState.test {
            selectedVideoResultFlow.emit(Result.failure(Exception("error")))
            cancelAndIgnoreRemainingEvents()
        }

        sut.handleEvent(VideoPlayerEvent.VideoSelected(videoItem))
        selectedVideoResultFlow.emit(Result.success(SelectedVideo(videoUrl, videoItem)))

        sut.uiState.test {
            assertEquals(VideoPlayerUIState.Fetched(videoUrl), awaitItem())
            ensureAllEventsConsumed()
        }
    }
}