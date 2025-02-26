package com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.usecase

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRail
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.repository.VideoRailsRepository

internal class FetchVideoRailsUseCaseImpl(
    private val repository: VideoRailsRepository
) : FetchVideoRailsUseCase {

    override suspend fun invoke(): Result<List<VideoRail>> =
        repository.fetchVideoRails()
}