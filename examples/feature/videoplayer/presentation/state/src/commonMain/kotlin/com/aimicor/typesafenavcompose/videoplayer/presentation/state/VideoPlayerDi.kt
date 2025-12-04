package com.aimicor.typesafenavcompose.videoplayer.presentation.state

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val videoPlayerStateModule = module {
    viewModel { VideoPlayerViewModel(get(), get()) } bind VideoPlayerUniflow::class
}