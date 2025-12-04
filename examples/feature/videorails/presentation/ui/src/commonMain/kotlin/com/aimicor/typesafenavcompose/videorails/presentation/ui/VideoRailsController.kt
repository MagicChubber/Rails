package com.aimicor.typesafenavcompose.videorails.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.aimicor.collect.collectFlow
import com.aimicor.collect.collectStateFlow
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerInfo
import com.aimicor.typesafenavcompose.videorails.presentation.state.VideoRailsSideEffect
import com.aimicor.typesafenavcompose.videorails.presentation.state.VideoRailsUniflow
import com.aimicor.typesafenavcompose.videorails.presentation.state.VideoRailsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun VideoRailsController(
    uniflow: VideoRailsUniflow = koinViewModel<VideoRailsViewModel>(),
    navigate: (VideoPlayerInfo) -> Unit
) {
    val state by uniflow.uiState.collectStateFlow()
    VideoRailsUiContent(state, uniflow::handleEvent)
    uniflow.sideEffect.collectFlow {
        when (it) {
            VideoRailsSideEffect.Exit -> TODO()
            is VideoRailsSideEffect.Navigate -> navigate(it.videoPlayerInfo)
        }
    }
}
