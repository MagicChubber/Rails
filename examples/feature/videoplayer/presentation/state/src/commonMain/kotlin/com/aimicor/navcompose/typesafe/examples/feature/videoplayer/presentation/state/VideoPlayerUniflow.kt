package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.state

import com.aimicor.uniflow.Uniflow

interface VideoPlayerUniflow
    : Uniflow<VideoPlayerEvent, VideoPlayerUIState, VideoPlayerSideEffect>