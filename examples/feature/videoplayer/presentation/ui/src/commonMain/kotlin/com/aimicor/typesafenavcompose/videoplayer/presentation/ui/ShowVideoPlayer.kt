package com.aimicor.typesafenavcompose.videoplayer.presentation.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aimicor.typesafenavcompose.presentation.ui.ShowLoading
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerUiState
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayingState
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import navcompose.examples.feature.videoplayer.presentation.ui.generated.resources.Res
import navcompose.examples.feature.videoplayer.presentation.ui.generated.resources.outline_error_24
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ShowVideoPlayer(
    state: VideoPlayingState,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onBackground,
            )
    ) {
        when (state) {
            VideoPlayingState.Error -> ShowError()
            is VideoPlayingState.Fetched -> PlayVideo(state.videoUrl)
            VideoPlayingState.Fetching -> ShowLoading()
        }
    }

//    Column {
//        VideoPlayerUiContent(state, uniflow::handleEvent)
//        Column(modifier = Modifier.padding(10.dp)) {
//            Text(
//                text = state.selectedVideo.video.title,
//                fontSize = MaterialTheme.typography.h4.fontSize
//            )
//            Text(
//                text = state.selectedVideo.video.description,
//                fontSize = MaterialTheme.typography.body2.fontSize
//            )
//            LazyColumn(modifier = Modifier.padding(top = 10.dp)) {
//                items(
//                    items = state.videos,
//                    key = { item -> item.id }
//                ) { ShowVideoRailItem(it) }
//            }
//        }
//    }
}

@Composable
fun PlayVideo(videoUrl: String) {
    TODO("Not yet implemented")
}

@Composable
fun ShowError() {
    Icon(painterResource(Res.drawable.outline_error_24),  null)
}
