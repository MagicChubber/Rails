package com.aimicor.typesafenavcompose.videoplayer.domain.usecase

import com.aimicor.typesafenavcompose.videoplayer.domain.entity.SelectedVideo
import com.aimicor.typesafenavcompose.videoplayer.domain.repository.VideoPlayerRepository
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

interface FetchSelectedVideoUseCase {
    suspend operator fun invoke(video: VideoRailItem): Result<SelectedVideo>
}

internal class FetchSelectedVideoUseCaseImpl(
    private val repository: VideoPlayerRepository
) : FetchSelectedVideoUseCase {

    override suspend fun invoke(
        video: VideoRailItem
    ): Result<SelectedVideo> = repository.fetchVideoUrl(video.id).fold(
        onSuccess = { Result.success(SelectedVideo(it, video)) },
        onFailure = { Result.failure(it) }
    )
}

val videoPlayerDomainModule = module {
    factoryOf(::FetchSelectedVideoUseCaseImpl) { bind<FetchSelectedVideoUseCase>() }
}
//https://live.staticflickr.com/video/53691497275/2fbfafa281/1080p.mp4?s=eyJpIjo1MzY5MTQ5NzI3NSwiZSI6MTc1MTI2ODM5MCwicyI6ImFlMTE4NGQ4MDU4MDEyMzI2MzA1MjQyMzc4MWIxMmFlMzM2ODg0YzQiLCJ2IjoxfQ
