package com.aimicor.typesafenavcompose.videoplayer.presentation.state

import com.aimicor.navtype.typePair
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import kotlinx.serialization.Serializable

@Serializable
data class VideoPlayerInfo(
    val selectedVideoItem: VideoRailItem,
    val videoRail: VideoRail
) {
    companion object{
        val typeMap = mapOf(typePair<VideoRail>(), typePair<VideoRailItem>())
    }
}
