package com.aimicor.typesafenavcompose.videorails.domain.usecase

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail

interface FetchVideoRailsUseCase {
    suspend operator fun invoke(): Result<List<VideoRail>>
}
