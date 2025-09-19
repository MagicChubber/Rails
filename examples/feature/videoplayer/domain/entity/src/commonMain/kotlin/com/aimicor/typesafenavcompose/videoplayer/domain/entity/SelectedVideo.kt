package com.aimicor.typesafenavcompose.videoplayer.domain.entity

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem

data class SelectedVideo(
    val videoUrl: String,
    val video: VideoRailItem,
)
