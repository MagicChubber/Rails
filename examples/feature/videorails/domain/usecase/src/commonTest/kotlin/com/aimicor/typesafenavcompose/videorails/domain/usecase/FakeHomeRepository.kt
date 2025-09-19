package com.aimicor.typesafenavcompose.videorails.domain.usecase

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail
import com.aimicor.typesafenavcompose.videorails.domain.repository.VideoRailsRepository

class FakeHomeRepository(
    val videoRailsResults: Result<List<VideoRail>> = Result.success(emptyList())
): VideoRailsRepository {
    override suspend fun fetchVideoRails(): Result<List<VideoRail>> = videoRailsResults
}