package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.aimicor.collectcmp.collectAsStateWithCmp
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state.VideoRailsUniflow

@Composable
fun VideoRailsController(
    uniflow: VideoRailsUniflow
) {
    val state by uniflow.uiState.collectAsStateWithCmp()
    VideoRailsUiContent(state, uniflow::handleEvent)
}
