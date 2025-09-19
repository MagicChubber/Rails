package com.aimicor.typesafenavcompose.videoplayer.presentation.state

import com.aimicor.uniflow.Uniflow

interface VideoPlayerUniflow
    : Uniflow<VideoPlayerEvent, VideoPlayerUiState, VideoPlayerSideEffect>