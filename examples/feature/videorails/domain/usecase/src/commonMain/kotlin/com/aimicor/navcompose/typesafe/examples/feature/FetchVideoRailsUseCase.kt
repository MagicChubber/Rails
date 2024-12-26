package com.aimicor.navcompose.typesafe.examples.feature

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRail
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.repository.VideoRailsRepository

interface FetchVideoRailsUseCase {
    suspend operator fun invoke(): Result<List<VideoRail>>

    companion object {
        operator fun invoke(
            repository: VideoRailsRepository
        ): FetchVideoRailsUseCase = FetchVideoRailsUseCaseImpl(repository)
    }
}

private class FetchVideoRailsUseCaseImpl(
    private val repository: VideoRailsRepository
) : FetchVideoRailsUseCase {

    override suspend fun invoke(): Result<List<VideoRail>> =
        repository.fetchVideoRails()
}