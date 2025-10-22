package com.aimicor.navcompose.typesafe.dependencies

import com.aimicor.typesafenavcompose.videoplayer.data.videoPlayerRepositoryModule
import com.aimicor.typesafenavcompose.videorails.data.videoRailsRepositoryModule
import com.aimicor.typesafenavcompose.videorails.domain.usecase.videoRailsUseCaseModule
import com.aimicor.typesafenavcompose.videorails.presentation.state.videoRailsStateModule
import org.koin.core.KoinApplication
import com.aimicor.collect.collectCommonModule
import com.aimicor.typesafenavcompose.videoplayer.domain.usecase.videoPlayerDomainModule
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.videoPlayerStateModule

fun KoinApplication.dependencies() {
    modules(
        videoPlayerDomainModule,
        videoRailsStateModule,
        videoPlayerStateModule,
        videoRailsUseCaseModule,
        videoRailsRepositoryModule,
        videoPlayerRepositoryModule,
        collectCommonModule
    )
}
