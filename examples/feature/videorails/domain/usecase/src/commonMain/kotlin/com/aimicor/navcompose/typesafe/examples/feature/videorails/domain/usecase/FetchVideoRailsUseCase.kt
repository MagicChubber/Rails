package com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.usecase

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRail
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.repository.VideoRailsRepository

interface FetchVideoRailsUseCase {
    suspend operator fun invoke(): Result<List<VideoRail>>
}
