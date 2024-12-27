package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state

import androidx.lifecycle.viewModelScope
import com.aimicor.navcompose.typesafe.examples.feature.FetchVideoRailsUseCase
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsEvent
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsUiState
import com.aimicor.uniflow.UniflowViewModel
import kotlinx.coroutines.launch

open class VideoRailsViewModel<EFFECT>(
    val fetchRailsUseCase: FetchVideoRailsUseCase
) : VideoRailsUniflow<EFFECT>, UniflowViewModel<VideoRailsEvent, VideoRailsUiState, EFFECT>(
    initialUiState = VideoRailsUiState.Loading
) {

    init {
        fetchVideoRails()
    }

    override fun handleEvent(event: VideoRailsEvent) {
        if (event is VideoRailsEvent.OnRetryClicked) setUiState {
            fetchVideoRails()
            VideoRailsUiState.Loading
        }
    }

    private fun fetchVideoRails() = viewModelScope.launch {
        fetchRailsUseCase().apply {
            onSuccess { setUiState { VideoRailsUiState.Success(it) } }
            onFailure { setUiState { VideoRailsUiState.Failed(it.message ?: "") } }
        }
    }
}