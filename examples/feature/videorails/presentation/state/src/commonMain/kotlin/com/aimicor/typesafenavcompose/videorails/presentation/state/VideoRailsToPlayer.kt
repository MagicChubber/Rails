package com.aimicor.typesafenavcompose.videorails.presentation.state

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import kotlinx.serialization.Serializable

@Serializable
data class VideoRailsToPlayer(
    val selectedVideo: VideoRailItem,
    val videoRail: VideoRail
)
