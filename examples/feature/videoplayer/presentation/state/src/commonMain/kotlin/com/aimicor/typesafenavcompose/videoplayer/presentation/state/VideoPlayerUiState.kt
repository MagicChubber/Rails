package com.aimicor.typesafenavcompose.videoplayer.presentation.state

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem

sealed class VideoPlayingState{
    data object Fetching : VideoPlayingState()
    data class Fetched(val videoUrl: String) : VideoPlayingState()
    data object Error : VideoPlayingState()
}

data class VideoItem (
    val video: VideoRailItem,
    val selected: Boolean
)
data class VideoPlayerUiState (
    val videos: List<VideoItem>,
    val videoPlayingState: VideoPlayingState
)