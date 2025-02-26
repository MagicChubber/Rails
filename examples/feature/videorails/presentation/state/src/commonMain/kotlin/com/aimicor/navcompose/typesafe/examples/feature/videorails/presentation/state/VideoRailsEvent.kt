package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRail
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.entity.VideoRailItem

sealed class VideoRailsEvent {
    data object OnCloseClicked : VideoRailsEvent()
    data object OnRetryClicked : VideoRailsEvent()
    data class OnVideoItemClicked(
        val videoRailItem: VideoRailItem,
        val videoRail: VideoRail
    ) : VideoRailsEvent()
}
