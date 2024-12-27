package com.aimicor.navcompose.typesafe.appwith.videorails

import app.cash.turbine.test
import com.aimicor.navcompose.typesafe.examples.feature.FetchVideoRailsUseCase
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRail
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRailItem
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state.VideoRailsViewModel
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsEvent
import com.aimicor.sunthumbs.infrastructure.test.TestCoroutineRule
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
class VideoRailsAppWithViewModelTest {

    @get:Rule
    val rule = TestCoroutineRule()

    private val testUseCase = object : FetchVideoRailsUseCase {
        override suspend fun invoke() = Result.success(emptyList<VideoRail>())
    }

    private val viewModel by lazy { VideoRailsAppWithViewModel(testUseCase) }

    @Test
    fun `WHEN back button event THEN effect is sent to view`() = runTest {
        // When
        viewModel.handleEvent(VideoRailsEvent.OnCloseClicked)

        // Then
        viewModel.sideEffect.test {
            assertTrue(awaitItem() is VideoRailsSideEffect.Close)
        }
    }

    @Test
    fun `WHEN video item clicked THEN effect is sent to view`() = runTest {
        // Given
        val id = "fsdffsdfsdf"
        val railTitle = "rail"
        val item = VideoRailItem(
            id = id,
            title = "",
            imgUrl = ""
        )
        val videoRail = VideoRail(
            title = railTitle,
            items = listOf(item)
        )

        // When
        viewModel.handleEvent(VideoRailsEvent.OnVideoItemClicked(item, videoRail))

        // Then
        viewModel.sideEffect.test {
            val effect = awaitItem()
            assertTrue(effect is VideoRailsSideEffect.GoToVideo)
            assertSame(videoRail, (effect as VideoRailsSideEffect.GoToVideo).videoRail)
            assertSame(item, effect.videoRailItem)
        }
    }
}