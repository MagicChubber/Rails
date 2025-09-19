package com.aimicor.typesafenavcompose.videoplayer.domain.repository

interface VideoPlayerRepository {
    suspend fun fetchVideoUrl(videoId: String): Result<String>
}