package com.aimicor.typesafenavcompose.videoplayer.presentation.state

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem

sealed class VideoPlayerEvent {
    data class VideoSelected(val videoItem: VideoRailItem) : VideoPlayerEvent()
    data object BackPress : VideoPlayerEvent()
}

