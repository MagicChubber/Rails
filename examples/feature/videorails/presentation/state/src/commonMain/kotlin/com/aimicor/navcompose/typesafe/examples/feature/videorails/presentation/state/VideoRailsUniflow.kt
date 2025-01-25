package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state

import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsEvent
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsUiState
import com.aimicor.uniflow.Uniflow

interface VideoRailsUniflow<EFFECT>
    : Uniflow<VideoRailsEvent, VideoRailsUiState, EFFECT>