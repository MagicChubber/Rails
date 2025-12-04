package com.aimicor.typesafenavcompose.videoplayer.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.aimicor.collect.collectFlow
import com.aimicor.collect.collectStateFlow
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerUniflow
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun VideoPlayerController (
    uniflow: VideoPlayerUniflow = koinViewModel<VideoPlayerViewModel>()
) {
    val state by uniflow.uiState.collectStateFlow()
    VideoPlayerUiContent(state, uniflow::handleEvent)
    uniflow.sideEffect.collectFlow {
    }
}
