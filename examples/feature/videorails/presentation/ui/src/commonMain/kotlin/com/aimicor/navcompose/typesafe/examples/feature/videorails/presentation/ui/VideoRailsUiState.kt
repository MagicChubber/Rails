package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRail

sealed class VideoRailsUiState {
    data object Loading : VideoRailsUiState()
    data class Failed(val message: String) : VideoRailsUiState()
    data class Success(val videoRailList: List<VideoRail>) : VideoRailsUiState()
}