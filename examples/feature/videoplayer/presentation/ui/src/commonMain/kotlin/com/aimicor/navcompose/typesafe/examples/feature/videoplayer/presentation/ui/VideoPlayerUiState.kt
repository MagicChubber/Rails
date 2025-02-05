package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.ui

import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.data.SelectedVideo
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRailItem

data class VideoPlayerUiState(
    val selectedVideo: SelectedVideo,
    val videos: List<VideoRailItem>
)
