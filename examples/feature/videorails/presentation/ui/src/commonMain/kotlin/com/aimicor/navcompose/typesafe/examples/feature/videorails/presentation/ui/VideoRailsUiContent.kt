package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui

import androidx.compose.runtime.Composable
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state.VideoRailsEvent
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state.VideoRailsUiState
import com.sunthhumbs.infrastructure.presentation.ui.ShowFailure
import com.sunthhumbs.infrastructure.presentation.ui.ShowLoading

@Composable
fun VideoRailsUiContent(
    state: VideoRailsUiState,
    event: (VideoRailsEvent) -> Unit
) {
    when (state) {
        is VideoRailsUiState.Loading -> ShowLoading()
        is VideoRailsUiState.Failed -> ShowFailure(
            state.message,
            { event(VideoRailsEvent.OnCloseClicked) },
            { event(VideoRailsEvent.OnRetryClicked) }
        )
        is VideoRailsUiState.Success -> ShowVideoRails(state.videoRailList, event)
    }
}
