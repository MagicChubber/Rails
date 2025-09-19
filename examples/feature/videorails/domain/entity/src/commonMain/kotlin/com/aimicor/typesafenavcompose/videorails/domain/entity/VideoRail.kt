package com.aimicor.typesafenavcompose.videorails.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class VideoRail(
    val title: String,
    val items: List<VideoRailItem>
)
