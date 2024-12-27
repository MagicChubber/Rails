package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state

import app.cash.turbine.test
import com.aimicor.navcompose.typesafe.examples.feature.FetchVideoRailsUseCase
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRail
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsEvent
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsUiState
import com.aimicor.sunthumbs.infrastructure.test.TestCoroutineRule
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.time.ExperimentalTime

@ExperimentalTime
class VideoRailsViewModelTest {

    @get:Rule
    val rule = TestCoroutineRule()

    private val resultFlow: Channel<Result<List<VideoRail>>> = Channel()

    private val testUseCase = object : FetchVideoRailsUseCase {
        override suspend fun invoke() = resultFlow.receive()
    }

    private val viewModel by lazy { VideoRailsViewModel<Unit>(testUseCase) }

    @Test
    fun `WHEN initialised THEN ui state is loading`() = runTest {
        viewModel.uiState.test{
            assertTrue(awaitItem() is VideoRailsUiState.Loading)
        }
    }

    @Test
    fun `GIVEN initialised WHEN failed response THEN ui state is failed 1`() = runTest {
        // Given
        viewModel
        val message = "Something went wrong"

        // When
        resultFlow.send(Result.failure((Throwable(message))))

        // Then
        viewModel.uiState.test{
            val item = awaitItem()
            assertTrue(item is VideoRailsUiState.Failed)
            assertEquals(message, item.message)
        }
    }

    @Test
    fun `GIVEN initialised WHEN failed response THEN ui state is failed 2`() = runTest {
        // Given
        viewModel
        val message = "Something went wrong 2"

        // When
        resultFlow.send(Result.failure((Throwable(message))))

        // Then
        viewModel.uiState.test{
            val item = awaitItem()
            assertTrue(item is VideoRailsUiState.Failed)
            assertEquals(message, item.message)
        }
    }

    @Test
    fun `GIVEN initialised WHEN success response THEN ui state is success`() = runTest {
        // Given
        viewModel
        val result: List<VideoRail> = emptyList()

        // When
        resultFlow.send(Result.success(result))

        // Then
        viewModel.uiState.test{
            val item = awaitItem()
            assertTrue(item is VideoRailsUiState.Success)
            assertEquals(result, item.videoRailList)
        }
    }

    @Test
    fun `GIVEN failed ui state WHEN retry event THEN ui state is loading`() = runTest {
        // Given
        viewModel
        resultFlow.send(Result.failure((Throwable())))

        // When
        viewModel.handleEvent(VideoRailsEvent.OnRetryClicked)

        // Then
        viewModel.uiState.test{
            assertTrue(awaitItem() is VideoRailsUiState.Loading)
        }
    }

    @Test
    fun `GIVEN retry WHEN failed then ui state is failed`() = runTest {
        // Given
        viewModel
        resultFlow.send(Result.failure((Throwable())))
        viewModel.handleEvent(VideoRailsEvent.OnRetryClicked)

        // When
        resultFlow.send(Result.failure((Throwable())))

        // Then
        viewModel.uiState.test{
            assertTrue(awaitItem() is VideoRailsUiState.Failed)
        }
    }

    @Test
    fun `GIVEN retry WHEN success then ui state is success`() = runTest {
        // Given
        viewModel
        resultFlow.send(Result.failure((Throwable())))
        viewModel.handleEvent(VideoRailsEvent.OnRetryClicked)

        // When
        resultFlow.send(Result.success(emptyList()))

        // Then
        viewModel.uiState.test{
            assertTrue(awaitItem() is VideoRailsUiState.Success)
        }
    }
}