package com.aimicor.typesafenavcompose.videoplayer.presentation.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aimicor.typesafenavcompose.presentation.ui.ShowLoading
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayingState
import navcompose.examples.feature.videoplayer.presentation.ui.generated.resources.Res
import navcompose.examples.feature.videoplayer.presentation.ui.generated.resources.outline_error_24
import org.jetbrains.compose.resources.painterResource

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
                color = MaterialTheme.colorScheme.onBackground,
            )
    ) {
        when (state) {
            VideoPlayingState.Error -> ShowError()
            is VideoPlayingState.Fetched -> PlayVideo(state.videoUrl)
            VideoPlayingState.Fetching -> ShowLoading()
        }
    }
}

@Composable
fun BoxScope.PlayVideo(videoUrl: String) {
    Text(videoUrl, modifier = Modifier.align(Alignment.Center))
}

@Composable
fun BoxScope.ShowError() {
    Icon(
        tint = MaterialTheme.colorScheme.error,
        modifier = Modifier.width(64.dp).align(Alignment.Center),
        painter = painterResource(Res.drawable.outline_error_24),
        contentDescription = null
    )
}
