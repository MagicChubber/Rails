package com.aimicor.navcompose.typesafe.appwith.videorails

import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRail
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRailItem

sealed class VideoRailsSideEffect {
    data class GoToVideo(
        val videoRail: VideoRail,
        val videoRailItem: VideoRailItem
    ) : VideoRailsSideEffect()
    data object Close : VideoRailsSideEffect()
}