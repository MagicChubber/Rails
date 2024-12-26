package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state

sealed class VideoRailsSideEffect {
    data class GoToVideo(val id: String) : VideoRailsSideEffect()
    data object Close : VideoRailsSideEffect()
}