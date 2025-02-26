package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state

import com.aimicor.uniflow.Uniflow

interface VideoRailsUniflow
    : Uniflow<VideoRailsEvent, VideoRailsUiState, VideoRailsSideEffect>