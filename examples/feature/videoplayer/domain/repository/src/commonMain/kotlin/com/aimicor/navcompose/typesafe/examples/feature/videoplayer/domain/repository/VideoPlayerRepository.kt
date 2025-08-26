package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.repository

interface VideoPlayerRepository {
    suspend fun fetchVideoUrl(videoId: String): Result<String>
}