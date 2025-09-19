package com.aimicor.typesafenavcompose.videoplayer.presentation.state

sealed class VideoPlayerSideEffect {
    data object NavigateBack : VideoPlayerSideEffect()
}