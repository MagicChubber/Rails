package com.aimicor.navcompose.typesafe

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation3.ui.NavDisplay
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerInfo
import com.aimicor.typesafenavcompose.videoplayer.presentation.ui.VideoPlayerController
import com.aimicor.typesafenavcompose.videorails.presentation.ui.VideoRails
import com.aimicor.typesafenavcompose.videorails.presentation.ui.VideoRailsController
import org.koin.compose.koinInject
import org.koin.compose.navigation3.koinEntryProvider
import org.koin.core.annotation.KoinExperimentalAPI

//@Composable
//fun App1() {
//    val navController = rememberNavController()
//    MaterialTheme {
//        NavHost(
//            navController = navController,
//            startDestination = VideoRails
//        ) {
//            composable<VideoRails> { VideoRailsController() { navController.navigate(it) } }
//            composable<VideoPlayerInfo>(VideoPlayerInfo.typeMap) { VideoPlayerController() }
//        }
//    }
//}

@Composable
@OptIn(KoinExperimentalAPI::class)
fun App() {
    val backStack: SnapshotStateList<Any> = koinInject()
    MaterialTheme {
        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = koinEntryProvider()
        )
    }
}

