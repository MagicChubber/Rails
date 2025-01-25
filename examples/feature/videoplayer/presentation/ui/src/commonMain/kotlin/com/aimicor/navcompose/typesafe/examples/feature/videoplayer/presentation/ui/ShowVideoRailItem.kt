package com.aimicor.navcompose.typesafe.examples.feature.videoplayer.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRailItem
import com.aimicor.navcompose.typesafe.examples.infrastructure.presentation.ui.ShowImage

@Composable
fun ShowVideoRailItem(videoItem: VideoRailItem) {
    Divider(
        color = MaterialTheme.colors.onSecondary,
        thickness = 1.dp,
        modifier = Modifier.padding(bottom = 5.dp)
    )
    Row {
        ShowImage(
            modifier = Modifier
                .padding(bottom = 5.dp)
                .height(40.dp)
                .border(BorderStroke(1.dp, MaterialTheme.colors.onBackground)),
        )
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 4.dp)
        ) {
            Text(
                text = videoItem.title,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = videoItem.description,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}