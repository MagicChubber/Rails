package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state

import androidx.lifecycle.viewModelScope
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.usecase.FetchVideoRailsUseCase
import com.aimicor.uniflow.UniflowViewModel
import kotlinx.coroutines.launch

internal class VideoRailsViewModel(
    val fetchRailsUseCase: FetchVideoRailsUseCase
) : VideoRailsUniflow, UniflowViewModel<VideoRailsEvent, VideoRailsUiState, VideoRailsSideEffect>(
    initialUiState = VideoRailsUiState.Loading
) {

    init {
        fetchVideoRails()
    }

    override fun handleEvent(event: VideoRailsEvent) {
        if (event is VideoRailsEvent.OnRetryClicked) setUiState {
            VideoRailsUiState.Loading
        }
        fetchVideoRails()
    }

    private fun fetchVideoRails() = viewModelScope.launch {
        fetchRailsUseCase().apply {
            onSuccess { setUiState { VideoRailsUiState.Success(it) } }
            onFailure { setUiState { VideoRailsUiState.Failed(it.message ?: "") } }
        }
    }
}