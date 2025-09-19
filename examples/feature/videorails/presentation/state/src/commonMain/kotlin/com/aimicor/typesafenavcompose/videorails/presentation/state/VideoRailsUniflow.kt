package com.aimicor.typesafenavcompose.videorails.presentation.state

import com.aimicor.uniflow.Uniflow

interface VideoRailsUniflow
    : Uniflow<VideoRailsEvent, VideoRailsUiState, VideoRailsSideEffect>