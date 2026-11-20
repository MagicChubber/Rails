package com.aimicor.typesafenavcompose.videoplayer.presentation.state

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val videoPlayerStateModule = module {
    viewModel { playerInfo ->
        VideoPlayerViewModel(
            fetchSelectedVideo = get(),
            playerInfo.get()
        )
    } bind VideoPlayerUniflow::class
}