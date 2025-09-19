package com.aimicor.typesafenavcompose.videorails.presentation.state

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail

sealed class VideoRailsUiState {
    data object Loading : VideoRailsUiState()
    data class Failed(val message: String) : VideoRailsUiState()
    data class Success(val videoRailList: List<VideoRail>) : VideoRailsUiState()
}