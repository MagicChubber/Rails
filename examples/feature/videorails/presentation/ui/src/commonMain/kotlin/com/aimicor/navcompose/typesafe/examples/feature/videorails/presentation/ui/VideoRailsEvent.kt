package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRail
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRailItem

sealed class VideoRailsEvent {
    data object OnCloseClicked : VideoRailsEvent()
    data object OnRetryClicked : VideoRailsEvent()
    data class OnVideoItemClicked(
        val videoRailItem: VideoRailItem,
        val videoRail: VideoRail
    ) : VideoRailsEvent()
}