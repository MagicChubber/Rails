package com.aimicor.typesafenavcompose.videoplayer.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerEvent
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerUiState

@Composable
fun VideoPlayerUiContent(
    state: VideoPlayerUiState,
    event: (VideoPlayerEvent) -> Unit
) {
    Column {
        ShowVideoPlayer(state.videoPlayingState)
        LazyColumn(modifier = Modifier.padding(top = 10.dp)) {
            items(
                items = state.videos,
                key = { item -> item.video.id }
            ) { ShowVideoRailItem(it) }
        }
    }
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .aspectRatio(16f / 9f)
//            .border(
//                width = 1.dp,
//                color = MaterialTheme.colors.onBackground,
//            )
//    ) {
//        Text(
//            text = state.,
//            fontSize = MaterialTheme.typography.body1.fontSize,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.align(Alignment.Center)
//        )
//    }
}