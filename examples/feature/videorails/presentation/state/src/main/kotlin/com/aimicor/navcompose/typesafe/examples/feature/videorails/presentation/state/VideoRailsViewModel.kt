package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state

import androidx.lifecycle.viewModelScope
import com.aimicor.navcompose.typesafe.examples.feature.FetchVideoRailsUseCase
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsEvent
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsUiState
import com.aimicor.uniflow.UniflowViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoRailsViewModel @Inject constructor(
    val homeUseCase: FetchVideoRailsUseCase
) : VideoRailsUniflow, UniflowViewModel<VideoRailsEvent, VideoRailsUiState, VideoRailsSideEffect>(
    initialUiState = VideoRailsUiState.Loading
) {

    init {
        fetchVideoRails()
    }

    override fun handleEvent(event: VideoRailsEvent) {
        when (event) {
            is VideoRailsEvent.OnCloseClicked -> sendSideEffect {
                VideoRailsSideEffect.Close
            }

            is VideoRailsEvent.OnRetryClicked -> setUiState {
                fetchVideoRails()
                VideoRailsUiState.Loading
            }

            is VideoRailsEvent.OnVideoItemClicked -> sendSideEffect {
                VideoRailsSideEffect.GoToVideo(event.videoRailItem.id)
            }
        }
    }

    private fun fetchVideoRails() = viewModelScope.launch {
        homeUseCase().apply {
            onSuccess { setUiState { VideoRailsUiState.Success(it) } }
            onFailure { setUiState { VideoRailsUiState.Failed(it.message ?: "") } }
        }
    }
}