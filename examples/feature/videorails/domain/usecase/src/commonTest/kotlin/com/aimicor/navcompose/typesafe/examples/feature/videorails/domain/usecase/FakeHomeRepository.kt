package com.aimicor.navcompose.typesafe.examples.feature.usecase

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRail
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.repository.VideoRailsRepository

class FakeHomeRepository(
    val videoRailsResults: Result<List<VideoRail>> = Result.success(emptyList())
): VideoRailsRepository {
    override suspend fun fetchVideoRails(): Result<List<VideoRail>> = videoRailsResults
}