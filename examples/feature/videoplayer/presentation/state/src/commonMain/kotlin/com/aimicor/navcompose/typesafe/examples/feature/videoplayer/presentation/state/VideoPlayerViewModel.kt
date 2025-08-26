package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.state

import androidx.lifecycle.viewModelScope
import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.entity.SelectedVideo
import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.usecase.FetchSelectedVideoUseCase
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRailItem
import com.aimicor.uniflow.UniflowViewModel
import kotlinx.coroutines.launch

class VideoPlayerViewModel(
    private val fetchSelectedVideo: FetchSelectedVideoUseCase,
    playerInfo: VideoPlayerInfo
) : VideoPlayerUniflow,
    UniflowViewModel<VideoPlayerEvent, VideoPlayerUIState, VideoPlayerSideEffect>(
        initialUiState = VideoPlayerUIState.Fetching(playerInfo)
    ) {

    init {
        fetchUrl(playerInfo.selectedVideoItem)
    }

    override fun handleEvent(event: VideoPlayerEvent) {
        when (event) {
            is VideoPlayerEvent.VideoSelected -> {
                fetchUrl(event.videoItem)
            }
        }
    }

    private fun fetchUrl(video: VideoRailItem) = viewModelScope.launch {
        fetchSelectedVideo(video).fold(
            onSuccess = ::setSelectedVideo,
            onFailure = { setFailure(video) }
        )
    }

    private fun setSelectedVideo(video: SelectedVideo) = setUiState {
        VideoPlayerUIState.Fetched(video.videoUrl)
    }

    private fun setFailure(videoRailItem: VideoRailItem) = setUiState {
        VideoPlayerUIState.Error(videoRailItem)
    }
}
