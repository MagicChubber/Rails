package com.aimicor.typesafenavcompose.videoplayer.presentation.state

import app.cash.turbine.test
import com.aimicor.typesafenavcompose.videoplayer.domain.entity.SelectedVideo
import com.aimicor.typesafenavcompose.videoplayer.domain.usecase.FetchSelectedVideoUseCase
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class VideoPlayerViewModelTest() {

    private var selectedVideoResult: Result<SelectedVideo>? = null
    private val selectedVideoResultFlow = MutableSharedFlow<Result<SelectedVideo>>()

    private val fetchSelectedVideoUseCase = object : FetchSelectedVideoUseCase {
        override suspend fun invoke(
            video: VideoRailItem
        ): Result<SelectedVideo> = selectedVideoResultFlow.first()
    }

    private val initialSelect = 5
    private val input by lazy {
        val videoList = mutableListOf<VideoRailItem>()
        for (i in 1..10) {
            val id = i.toString()
            videoList.add(
                VideoRailItem(
                    id = id,
                    title = "title$id",
                    description = "description$id",
                    imgUrl = "imgUrl$id"
                )
            )
        }
        VideoPlayerInfo(
            selectedVideoItem = videoList[initialSelect],
            videoRail = videoList
        )
    }

    private val output by lazy {
        val expectedList = input.videoRail.map {
            VideoItem(video = it, selected = false)
        }.toMutableList()
        expectedList[initialSelect] = expectedList[initialSelect].copy(selected = true)
        VideoPlayerUiState(expectedList, VideoPlayingState.Fetching)
    }

    private val sut by lazy {
        VideoPlayerViewModel(fetchSelectedVideoUseCase, input)
    }

    @Test
    fun `GIVEN selection WHEN first displayed THEN video selected is fetching`() = runTest {
        sut.uiState.test {
            assertEquals(output, awaitItem())
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun `GIVEN url fetch WHEN fail THEN video selected is error`() = runTest {
        sut.uiState.test {
            awaitItem()

            selectedVideoResultFlow.emit(Result.failure(Exception("error")))

            assertEquals(output.copy(videoPlayingState = VideoPlayingState.Error), awaitItem())
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun `GIVEN url fetch WHEN success THEN video selected is fetched`() = runTest {
        val videoUrl = "url"
        sut.uiState.test {
            awaitItem()

            selectedVideoResultFlow.emit(
                Result.success(
                    SelectedVideo(
                        videoUrl,
                        input.selectedVideoItem
                    )
                )
            )

            assertEquals(
                output.copy(videoPlayingState = VideoPlayingState.Fetched(videoUrl)),
                awaitItem()
            )
            ensureAllEventsConsumed()
        }
    }

    @Test
    fun `GIVEN video loading failed WHEN new video selected THEN new state fetching`() = runTest {
        val selection = 1
        sut.uiState.test {
            awaitItem()
            selectedVideoResultFlow.emit(Result.failure(Exception("error")))
            awaitItem()

            sut.handleEvent(VideoPlayerEvent.VideoSelected(input.videoRail[selection]))

            val videoList = output.videos.map { VideoItem(it.video, false) }.toMutableList()
            videoList[selection] = videoList[selection].copy(selected = true)
            assertEquals(output.copy(videos = videoList), awaitItem())
        }
    }

    @Test
    fun `GIVEN video loading failed and new video selected WHEN new fetch fails then new state failed`() =
        runTest {
            val selection = 2
            sut.uiState.test {
                awaitItem()
                selectedVideoResultFlow.emit(Result.failure(Exception("error")))
                awaitItem()
                sut.handleEvent(VideoPlayerEvent.VideoSelected(input.videoRail[selection]))
                awaitItem()

                selectedVideoResultFlow.emit(Result.failure(Exception("error")))

                val videoList = output.videos.map { VideoItem(it.video, false) }.toMutableList()
                videoList[selection] = videoList[selection].copy(selected = true)
                assertEquals(
                    output.copy(
                        videos = videoList,
                        videoPlayingState = VideoPlayingState.Error
                    ), awaitItem()
                )
            }
        }

    @Test
    fun `GIVEN video loading failed and new video selected WHEN new fetch succeeds then new state success`() =
        runTest {
            val videoUrl = "url"
            val selection = 3
            sut.uiState.test {
                awaitItem()
                selectedVideoResultFlow.emit(Result.failure(Exception("error")))
                awaitItem()
                sut.handleEvent(VideoPlayerEvent.VideoSelected(input.videoRail[selection]))
                awaitItem()

                selectedVideoResultFlow.emit(
                    Result.success(
                        SelectedVideo(
                            videoUrl,
                            input.videoRail[selection]
                        )
                    )
                )

                val videoList = output.videos.map { VideoItem(it.video, false) }.toMutableList()
                videoList[selection] = videoList[selection].copy(selected = true)
                assertEquals(
                    output.copy(
                        videos = videoList,
                        videoPlayingState = VideoPlayingState.Fetched(videoUrl)
                    ), awaitItem()
                )
            }
        }

    @Test
    fun `GIVEN non fetching state WHEN back pressed THEN home screen displayed`() = runTest {
        sut.uiState.test {
            awaitItem()
            selectedVideoResultFlow.emit(Result.failure(Exception("error")))
            awaitItem()

            sut.handleEvent(VideoPlayerEvent.BackPress)

            sut.sideEffect.test {
                assertEquals(VideoPlayerSideEffect.NavigateBack, awaitItem())
            }
        }
    }
}
