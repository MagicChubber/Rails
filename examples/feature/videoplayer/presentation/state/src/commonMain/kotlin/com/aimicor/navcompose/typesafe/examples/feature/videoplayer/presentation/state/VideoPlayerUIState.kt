package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.state

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRailItem

sealed class VideoPlayerUIState {
    data class Fetching(val videoPlayerInfo: VideoPlayerInfo) : VideoPlayerUIState()
    data class Error(val failedVideoItem: VideoRailItem) : VideoPlayerUIState()
    data class Fetched(val videoUrl: String) : VideoPlayerUIState()
}