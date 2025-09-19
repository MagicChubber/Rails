package com.aimicor.typesafenavcompose.videorails.presentation.state

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem

sealed class VideoRailsEvent {
    data object OnCloseClicked : VideoRailsEvent()
    data object OnRetryClicked : VideoRailsEvent()
    data class OnVideoItemClicked(
        val videoRailItem: VideoRailItem,
        val videoRail: VideoRail
    ) : VideoRailsEvent()
}
