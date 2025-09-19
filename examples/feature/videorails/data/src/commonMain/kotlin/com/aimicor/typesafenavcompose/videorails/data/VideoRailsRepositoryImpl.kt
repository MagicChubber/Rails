package com.aimicor.typesafenavcompose.videorails.data

import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRail
import com.aimicor.typesafenavcompose.videorails.domain.entity.VideoRailItem
import com.aimicor.typesafenavcompose.videorails.domain.repository.VideoRailsRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val videoRailsRepositoryModule = module {
    factoryOf(::VideoRailsRepositoryImpl) { bind<VideoRailsRepository>() }
}

private class VideoRailsRepositoryImpl : VideoRailsRepository {

    private val videoRails: List<VideoRail> = mutableListOf<VideoRail>().apply {
        val videoItem = VideoRailItem(
            id = "",
            title = "",
            description = "the cat sat on the mat and it was a sprat in a river that did not deliver",
            imgUrl = "https://www.blah.com/blah?blah1=blah1&blah2=3"
        )
        for (rail in 0..99) {
            val videoRailItems = mutableListOf<VideoRailItem>()
            for (item in 0..99) {
                videoRailItems.add(videoItem.copy(id = "$rail-$item", title = "Video $item in rail $rail"))
            }
            add(VideoRail(title = "Rail $rail", items = videoRailItems))
        }
    }

    override suspend fun fetchVideoRails(): Result<List<VideoRail>> =
        Result.success(videoRails)
}
