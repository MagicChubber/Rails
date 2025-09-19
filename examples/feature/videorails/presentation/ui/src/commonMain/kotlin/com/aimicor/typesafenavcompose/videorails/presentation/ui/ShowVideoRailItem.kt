package com.aimicor.typesafenavcompose.videorails.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import com.aimicor.typesafenavcompose.presentation.ui.ShowImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ShowVideoRailItem(
    modifier: Modifier = Modifier,
    videoItem: VideoRailItem,
    itemSelected: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() } // Create an interaction source

    Column(
        modifier = modifier
            .width(160.dp)
            .clickable(
                onClick = { itemSelected() },
                indication = LocalIndication.current, // Explicitly provide the current indication
                interactionSource = interactionSource // Provide the interaction source
            )
    ) {
        ShowImage(
            modifier = Modifier
                .height(90.dp)
                .fillMaxWidth()
                .border(BorderStroke(1.dp, MaterialTheme.colors.onBackground)),
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
        description = "the cat sat on the mat and it was a sprat in a river that did not deliver",
        imgUrl = "https://live.staticflickr.com/31337/53691497275_2fbfafa281.jpg"
    )
    ShowVideoRailItem(videoItem = videoItem) {}
}