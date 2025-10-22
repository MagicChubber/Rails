package com.aimicor.typesafenavcompose.videorails.presentation.state

import app.cash.turbine.test
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerInfo
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import com.aimicor.typesafenavcompose.videorails.domain.usecase.FetchVideoRailsUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class VideoRailsViewModelTest {

    private var fetchCount = 0
    private val fetchResult: MutableSharedFlow<Result<List<VideoRail>>> = MutableSharedFlow()
    private val fetchUseCase = object : FetchVideoRailsUseCase {
        override suspend fun invoke(): Result<List<VideoRail>> {
            fetchCount++
            return fetchResult.first()
        }
    }

    private val videoRails: List<VideoRail> = mutableListOf<VideoRail>().apply {
        val videoItem = VideoRailItem(
            id = "",
            title = "",
            description = "the cat sat on the mat and it was a sprat in a river that did not deliver",
            imgUrl = "https://www.blah.com/blah?blah1=blah1&blah2=3"
        )
        for (rail in 0..99) {
            val videoRailItems = mutableListOf<VideoRailItem>()
            for (item in 0..99) {
                videoRailItems.add(videoItem.copy(id = "$rail-$item", title = "Video $item in rail $rail"))
            }
            add(VideoRail(title = "Rail $rail", items = videoRailItems))
        }
    }

    private val sut by lazy { VideoRailsViewModel(fetchUseCase) }

    @Test
    fun `WHEN initialize THEN state is loading`() = runTest {
        // When
        sut.uiState.test {

            // Then
            assertEquals(VideoRailsUiState.Loading, awaitItem())
        }
    }

    @Test
    fun `GIVEN initialize WHEN fetch succeeds THEN state is success`() = runTest {
        // Given
        val videoRailList = emptyList<VideoRail>()
        sut.uiState.test {
            awaitItem()

            // When
            fetchResult.emit(Result.success(videoRailList))

            // Then
            assertEquals(VideoRailsUiState.Success(videoRailList), awaitItem())
        }
    }

    @Test
    fun `GIVEN initialize WHEN fetch fails THEN state is error`() = runTest {
        // Given
        val message = "test"
        val exception = Throwable(message = message)
        sut.uiState.test {
            awaitItem()

            // When
            fetchResult.emit(Result.failure(exception))

            // Then
            assertEquals(VideoRailsUiState.Failed(message), awaitItem())
        }
    }

    @Test
    fun `GIVEN failed state WHEN retry THEN state is loading AND new results fetched`() = runTest {
        // Given
        sut.uiState.test {
            awaitItem()
            fetchResult.emit(Result.failure(Throwable()))
            awaitItem()

            // When
            sut.handleEvent(VideoRailsEvent.OnRetryClicked)

            // Then
            assertEquals(VideoRailsUiState.Loading, awaitItem())

            // And
            assertEquals(2, fetchCount)
        }
    }

    @Test
    fun `GIVEN failed state WHEN back THEN side effect is exit`() = runTest {
        // Given
        sut.uiState.test {
            awaitItem()
            fetchResult.emit(Result.failure(Throwable()))
            awaitItem()

            // When
            sut.handleEvent(VideoRailsEvent.OnCloseClicked)

            // Then
           sut.sideEffect.test {
               assertEquals(VideoRailsSideEffect.Exit, awaitItem())
           }
        }
    }

    @Test
    fun `GIVEN successful state WHEN rail selected THEN navigate side effect`() = runTest {
        // Given
        sut.uiState.test {
            awaitItem()
            fetchResult.emit(Result.success(videoRails))
            awaitItem()

            // When
            sut.handleEvent(VideoRailsEvent.OnVideoItemClicked(videoRails[1].items[1], videoRails[1]))

            // Then
            sut.sideEffect.test {
                assertEquals(VideoRailsSideEffect.Navigate(VideoPlayerInfo(videoRails[1].items[1], videoRails[1])), awaitItem())
            }
        }
    }
}
