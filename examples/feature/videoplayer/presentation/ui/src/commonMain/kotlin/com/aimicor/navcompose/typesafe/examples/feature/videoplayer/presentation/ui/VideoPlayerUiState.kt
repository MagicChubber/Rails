package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.ui

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRailItem

data class VideoPlayerUiState(
    val selectedVideo: VideoRailItem,
    val videos: List<VideoRailItem>
)
