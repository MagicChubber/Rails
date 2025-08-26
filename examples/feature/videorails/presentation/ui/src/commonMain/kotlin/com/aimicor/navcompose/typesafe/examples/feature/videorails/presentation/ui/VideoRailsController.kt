package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.aimicor.collect.collectFlow
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state.VideoRailsViewModel
import org.koin.compose.viewmodel.koinViewModel
import com.aimicor.collect.collectStateFlow
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state.VideoRailsUniflow

@Composable
fun VideoRailsController(
    uniflow: VideoRailsUniflow = koinViewModel<VideoRailsViewModel>()
) {
    val state by uniflow.uiState.collectStateFlow()
    VideoRailsUiContent(state, uniflow::handleEvent)
    uniflow.sideEffect.collectFlow {

    }
}
