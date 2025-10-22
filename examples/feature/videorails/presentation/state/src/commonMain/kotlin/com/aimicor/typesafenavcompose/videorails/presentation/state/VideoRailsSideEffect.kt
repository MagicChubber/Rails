package com.aimicor.typesafenavcompose.videorails.presentation.state

import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerInfo

sealed class VideoRailsSideEffect {
    data class Navigate(val videoPlayerInfo: VideoPlayerInfo) : VideoRailsSideEffect()
    data object Exit : VideoRailsSideEffect()
}