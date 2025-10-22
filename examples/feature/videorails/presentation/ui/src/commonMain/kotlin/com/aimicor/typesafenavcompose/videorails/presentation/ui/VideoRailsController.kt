package com.aimicor.typesafenavcompose.videorails.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.aimicor.collect.collectFlow
import com.aimicor.collect.collectStateFlow
import com.aimicor.typesafenavcompose.videorails.presentation.state.VideoRailsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun VideoRailsController(
    uniflow: VideoRailsViewModel = koinViewModel()
) {
    val state by uniflow.uiState.collectStateFlow()
    VideoRailsUiContent(state, uniflow::handleEvent)
    uniflow.sideEffect.collectFlow {

    }
}
