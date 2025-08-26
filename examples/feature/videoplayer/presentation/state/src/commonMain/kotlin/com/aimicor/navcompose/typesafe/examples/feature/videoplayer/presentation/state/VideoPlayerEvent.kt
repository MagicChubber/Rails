package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.state

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRailItem

sealed class VideoPlayerEvent {
    data class VideoSelected(val videoItem: VideoRailItem) : VideoPlayerEvent()
}

