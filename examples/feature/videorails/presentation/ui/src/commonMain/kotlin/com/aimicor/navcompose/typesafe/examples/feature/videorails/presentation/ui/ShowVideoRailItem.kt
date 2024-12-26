package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.aimicor.navcompose.typesafe.examples.feature.videorails.domain.data.VideoRailItem
import navcompose.examples.feature.videorails.presentation.ui.generated.resources.Res
import navcompose.examples.feature.videorails.presentation.ui.generated.resources.placeholder_landscape
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ShowVideoRailItem(
    modifier: Modifier = Modifier,
    videoItem: VideoRailItem,
    itemSelected: () -> Unit
) {
    Column(
        modifier = modifier
            .width(160.dp)
            .clickable { itemSelected() }
    ) {
        Image(
            modifier = Modifier
                .height(90.dp)
                .fillMaxWidth()
                .border(BorderStroke(1.dp, MaterialTheme.colors.onBackground)),
            painter = painterResource(Res.drawable.placeholder_landscape),
            contentDescription = null,
        )
        Text(
            text = videoItem.title,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
private fun ShowVideoRailItemPreview() {
    val videoItem = VideoRailItem(
        id = "",
        title = "me dropping spaghetti dropping spaghetti",
        imgUrl = "https://live.staticflickr.com/31337/53691497275_2fbfafa281.jpg"
    )
    ShowVideoRailItem(videoItem = videoItem) {}
}