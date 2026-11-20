package com.aimicor.typesafenavcompose.videorails.presentation.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.aimicor.typesafenavcompose.videorails.presentation.state.VideoRailsViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation

val videoRailsUiDi = module {
    single<SnapshotStateList<Any>> { mutableStateListOf(VideoRails) }

    navigation<VideoRails> {
        VideoRailsController(
            uniflow = koinViewModel<VideoRailsViewModel>(),
            navigate = { get<SnapshotStateList<Any>>().add(it) })
    }
}