package com.aimicor.typesafenavcompose.videoplayer.presentation.state

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.aimicor.typesafenavcompose.videoplayer.domain.usecase.FetchSelectedVideoUseCase
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import com.aimicor.uniflow.UniflowViewModel
import kotlinx.coroutines.launch

class VideoPlayerViewModel(
    private val fetchSelectedVideo: FetchSelectedVideoUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val playerInfo: VideoPlayerInfo = savedStateHandle.toRoute(VideoPlayerInfo.typeMap)
) : VideoPlayerUniflow,
    UniflowViewModel<VideoPlayerEvent, VideoPlayerUiState, VideoPlayerSideEffect>(
        initialUiState = VideoPlayerUiState(
            videos = playerInfo.videoRail.items.map {
                VideoItem(
                    video = it,
                    selected = it == playerInfo.selectedVideoItem
                )
            },
            videoPlayingState = VideoPlayingState.Fetching
        )
    ) {

    init {
        fetchUrl(playerInfo.selectedVideoItem)
    }

    override fun handleEvent(event: VideoPlayerEvent) {
        when (event) {
            is VideoPlayerEvent.VideoSelected -> {
                setUiState {
                    copy(
                        videos = videos.map {
                            it.copy(selected = it.video == event.videoItem)
                        },
                        videoPlayingState = VideoPlayingState.Fetching
                    )
                }
                fetchUrl(event.videoItem)
            }

            VideoPlayerEvent.BackPress -> sendSideEffect {
                VideoPlayerSideEffect.NavigateBack
            }
        }
    }

    private fun fetchUrl(video: VideoRailItem) = viewModelScope.launch {
        fetchSelectedVideo(video).fold(
            onSuccess = {
                setUiState {
                    copy(videoPlayingState = VideoPlayingState.Fetched(it.videoUrl))
                }
            },
            onFailure = {
                setUiState {
                    copy(videoPlayingState = VideoPlayingState.Error)
                }
            }
        )
    }
  }
