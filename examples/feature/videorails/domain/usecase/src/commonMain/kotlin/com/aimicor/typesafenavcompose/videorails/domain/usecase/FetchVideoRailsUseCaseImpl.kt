package com.aimicor.typesafenavcompose.videorails.domain.usecase

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail
import com.aimicor.typesafenavcompose.videorails.domain.repository.VideoRailsRepository

internal class FetchVideoRailsUseCaseImpl(
    private val repository: VideoRailsRepository
) : FetchVideoRailsUseCase {

    override suspend fun invoke(): Result<List<VideoRail>> =
        repository.fetchVideoRails()
}