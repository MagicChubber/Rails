package com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.repository

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRail

interface VideoRailsRepository {
    suspend fun fetchVideoRails(): Result<List<VideoRail>>
    companion object
}
