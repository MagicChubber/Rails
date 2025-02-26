package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.usecase

import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.entity.SelectedVideo
import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.repository.VideoPlayerRepository
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRailItem

interface FetchSelectedVideoUseCase {
    suspend operator fun invoke(video: VideoRailItem): Result<SelectedVideo>

    companion object {
        operator fun invoke(
            repository: VideoPlayerRepository
        ): FetchSelectedVideoUseCase = FetchSelectedVideoUseCaseImpl(repository)
    }
}

private class FetchSelectedVideoUseCaseImpl(
    private val repository: VideoPlayerRepository
) : FetchSelectedVideoUseCase {

    override suspend fun invoke(video: VideoRailItem): Result<SelectedVideo> {
        TODO("Not yet implemented")
    }
}