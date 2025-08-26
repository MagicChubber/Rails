package com.aimicor.navcompose.typesafe.dependencies

import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.data.videoPlayerRepositoryModule
import com.aimicor.navcompose.typesafe.examples.feature.videorails.data.videoRailsRepositoryModule
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.usecase.videoRailsUseCaseModule
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state.videoRailsStateModule
import org.koin.core.KoinApplication
import com.aimicor.collect.collectCommonModule
import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.usecase.videoPlayerDomainModule

fun KoinApplication.dependencies() {
    modules(
        videoPlayerDomainModule,
        videoRailsStateModule,
        videoRailsUseCaseModule,
        videoRailsRepositoryModule,
        videoPlayerRepositoryModule,
        collectCommonModule
    )
}
