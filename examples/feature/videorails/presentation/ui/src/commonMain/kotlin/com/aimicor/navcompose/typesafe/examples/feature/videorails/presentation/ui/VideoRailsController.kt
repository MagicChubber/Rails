package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state.VideoRailsViewModel
import org.koin.compose.viewmodel.koinViewModel
import com.aimicor.collect.collectStateFlow

@Composable
fun VideoRailsController(
    uniflow: VideoRailsViewModel = koinViewModel()
) {
    val state by uniflow.uiState.collectStateFlow()
    VideoRailsUiContent(state, uniflow::handleEvent)
}
