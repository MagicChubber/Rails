package com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class VideoRailItem(
    val id: String,
    val title: String,
    val description: String,
    val imgUrl: String
)
