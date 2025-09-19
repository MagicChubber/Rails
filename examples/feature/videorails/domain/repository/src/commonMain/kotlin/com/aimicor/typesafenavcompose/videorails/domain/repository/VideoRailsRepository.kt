package com.aimicor.typesafenavcompose.videorails.domain.repository

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail

interface VideoRailsRepository {
    suspend fun fetchVideoRails(): Result<List<VideoRail>>
    companion object
}
