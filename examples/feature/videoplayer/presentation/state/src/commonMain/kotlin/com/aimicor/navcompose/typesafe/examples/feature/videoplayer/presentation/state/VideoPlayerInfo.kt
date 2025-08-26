package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.state

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRailItem
import kotlinx.serialization.Serializable

@Serializable
data class VideoPlayerInfo (
    val selectedVideoItem: VideoRailItem,
    val categoryList: List<VideoRailItem>
)