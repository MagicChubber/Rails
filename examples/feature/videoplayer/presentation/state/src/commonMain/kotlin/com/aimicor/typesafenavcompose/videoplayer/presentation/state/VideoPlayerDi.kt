package com.aimicor.typesafenavcompose.videoplayer.presentation.state

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val videoPlayerStateModule = module {
    viewModelOf(::VideoPlayerViewModel) { bind<VideoPlayerUniflow>() }
}