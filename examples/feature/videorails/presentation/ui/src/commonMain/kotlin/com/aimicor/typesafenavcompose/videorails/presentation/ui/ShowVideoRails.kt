package com.aimicor.typesafenavcompose.videorails.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import com.aimicor.typesafenavcompose.videorails.presentation.state.VideoRailsEvent
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShowVideoRails(
    videoRailList: List<VideoRail>,
    event: (VideoRailsEvent) -> Unit
) {
    LazyColumn {
        items(
            items = videoRailList,
            key = { rail -> rail.title }
        ) { rail ->
            Text(
                text = rail.title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge,
                lineHeight = 35.sp,
                modifier = Modifier.padding(bottom = 6.dp)
            )
            LazyRow {
                items(
                    items = rail.items,
                    key = { item -> item.id }
                ) { item ->
                    ShowVideoRailItem(
                        modifier = Modifier.padding(end = 5.dp),
                        videoItem = item,
                        itemSelected = { event(VideoRailsEvent.OnVideoItemClicked(item, rail)) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ShowVideoRailsPreview() {
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
    val videoRails = mutableListOf<VideoRail>()
    for (i in 0..9) {
        videoRails.add(VideoRail(title = "$i - rail", items = videoRailItems))
    }
    ShowVideoRails(videoRails) {}
}
