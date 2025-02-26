package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.entity

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRailItem

data class SelectedVideo(
    val videoUrl: String,
    val video: VideoRailItem,
)
