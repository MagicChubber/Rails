package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.data

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRailItem

data class SelectedVideo(
    val videoUrl: String,
    val video: VideoRailItem,
)
