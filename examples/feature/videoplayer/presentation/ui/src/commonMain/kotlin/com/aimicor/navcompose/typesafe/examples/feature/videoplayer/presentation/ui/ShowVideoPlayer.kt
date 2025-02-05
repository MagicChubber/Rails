package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aimicor.navcompose.typesafe.examples.feature.videoplayer.domain.data.SelectedVideo
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRailItem
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ShowVideoPlayer(
    state: VideoPlayerUiState,
    event: (VideoRailItem) -> Unit
) {
    Column {
        VideoPlayer(state)
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = state.selectedVideo.video.title,
                fontSize = MaterialTheme.typography.h4.fontSize
            )
            Text(
                text = state.selectedVideo.video.description,
                fontSize = MaterialTheme.typography.body2.fontSize
            )
            LazyColumn(modifier = Modifier.padding(top = 10.dp)) {
                items(
                    items = state.videos,
                    key = { item -> item.id }
                ) { ShowVideoRailItem(it) }
            }
        }
    }
}

@Preview
@Composable
private fun ShowVideoPlayerPreview() {
    val videoItem = VideoRailItem(
        id = "",
        title = "",
        description = "the cat sat on the mat and it was a sprat in a river that did not deliver",
        imgUrl = "https://live.staticflickr.com/31337/53691497275_2fbfafa281.jpg"
    )
    val videoRailItems = mutableListOf<VideoRailItem>()
    for (i in 0..9) {
        videoRailItems.add(videoItem.copy(id = i.toString(), title = "$i video"))
    }
    val state = VideoPlayerUiState(
        selectedVideo = SelectedVideo(
            videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
            video = videoItem
        ),
        videos = videoRailItems
    )
    ShowVideoPlayer(state) {}
}