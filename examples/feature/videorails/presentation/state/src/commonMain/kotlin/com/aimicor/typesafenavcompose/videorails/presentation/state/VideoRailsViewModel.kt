package com.aimicor.typesafenavcompose.videorails.presentation.state

import androidx.lifecycle.viewModelScope
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerInfo
import com.aimicor.typesafenavcompose.videorails.domain.usecase.FetchVideoRailsUseCase
import com.aimicor.uniflow.UniflowViewModel
import kotlinx.coroutines.launch

class VideoRailsViewModel(
    private val fetchRailsUseCase: FetchVideoRailsUseCase
) : VideoRailsUniflow, UniflowViewModel<VideoRailsEvent, VideoRailsUiState, VideoRailsSideEffect>(
    initialUiState = VideoRailsUiState.Loading
) {

    init {
        fetchVideoRails()
    }

    override fun handleEvent(event: VideoRailsEvent) {
        when (event) {
            VideoRailsEvent.OnCloseClicked -> sendSideEffect {
                VideoRailsSideEffect.Exit
            }
            VideoRailsEvent.OnRetryClicked -> {
                 fetchVideoRails()
            }
            is VideoRailsEvent.OnVideoItemClicked -> sendSideEffect {
                VideoRailsSideEffect.Navigate(VideoPlayerInfo(event.videoRailItem, event.videoRail))
            }
        }

    }

    private fun fetchVideoRails() = viewModelScope.launch {
        setUiState { VideoRailsUiState.Loading }
        fetchRailsUseCase()
            .onSuccess { setUiState { VideoRailsUiState.Success(it) } }
            .onFailure { setUiState { VideoRailsUiState.Failed(it.message ?: "") } }
    }
}