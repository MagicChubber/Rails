package com.aimicor.typesafenavcompose.videoplayer.data

import com.aimicor.typesafenavcompose.videoplayer.domain.repository.VideoPlayerRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

private class VideoPlayerRepositoryImpl : VideoPlayerRepository {

    override suspend fun fetchVideoUrl(videoId: String): Result<String> {
        return Result.success("https://live.staticflickr.com/video/53691497275/2fbfafa281/1080p.mp4?s=eyJpIjo1MzY5MTQ5NzI3NSwiZSI6MTc1MTI2ODM5MCwicyI6ImFlMTE4NGQ4MDU4MDEyMzI2MzA1MjQyMzc4MWIxMmFlMzM2ODg0YzQiLCJ2IjoxfQ")
    }
}

val videoPlayerRepositoryModule = module {
    factoryOf(::VideoPlayerRepositoryImpl) { bind<VideoPlayerRepository>() }
}
