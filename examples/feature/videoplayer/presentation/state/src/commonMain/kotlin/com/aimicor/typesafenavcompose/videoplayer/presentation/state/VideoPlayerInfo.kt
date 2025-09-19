package com.aimicor.typesafenavcompose.videoplayer.presentation.state

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import kotlinx.serialization.Serializable

@Serializable
data class VideoPlayerInfo (
    val selectedVideoItem: VideoRailItem,
    val categoryList: List<VideoRailItem>
)