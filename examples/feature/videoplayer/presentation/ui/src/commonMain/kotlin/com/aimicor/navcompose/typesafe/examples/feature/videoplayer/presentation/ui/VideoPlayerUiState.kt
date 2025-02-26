package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.ui

import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.entity.SelectedVideo
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRailItem

data class VideoPlayerUiState(
    val selectedVideo: SelectedVideo,
    val videos: List<VideoRailItem>
)
