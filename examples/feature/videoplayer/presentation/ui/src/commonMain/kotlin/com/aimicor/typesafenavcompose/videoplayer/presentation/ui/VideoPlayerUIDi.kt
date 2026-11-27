package com.aimicor.typesafenavcompose.videoplayer.presentation.ui

import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerInfo
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

@OptIn(KoinExperimentalAPI::class)
val videoPlayerUiModule = module {
    navigation<VideoPlayerInfo> { playerInfo ->
        VideoPlayerController(koinViewModel<VideoPlayerViewModel> { parametersOf(playerInfo) })
    }
}