package com.aimicor.navcompose.typesafe.appwith.videorails

import com.aimicor.navcompose.typesafe.examples.feature.FetchVideoRailsUseCase
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state.VideoRailsViewModel
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoRailsAppWithViewModel @Inject constructor(
    fetchRailsUseCase: FetchVideoRailsUseCase
) : VideoRailsAppWithUniflow, VideoRailsViewModel<VideoRailsSideEffect>(fetchRailsUseCase) {

    override fun handleEvent(event: VideoRailsEvent) {
        when (event) {
            is VideoRailsEvent.OnCloseClicked -> sendSideEffect { VideoRailsSideEffect.Close }
            is VideoRailsEvent.OnVideoItemClicked -> event.apply {
                sendSideEffect { VideoRailsSideEffect.GoToVideo(videoRail, videoRailItem) }
            }
            else -> super.handleEvent(event)
        }
    }
}