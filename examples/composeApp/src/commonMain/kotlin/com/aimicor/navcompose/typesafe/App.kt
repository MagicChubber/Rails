package com.aimicor.navcompose.typesafe

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aimicor.typesafenavcompose.videoplayer.presentation.state.VideoPlayerInfo
import com.aimicor.typesafenavcompose.videoplayer.presentation.ui.VideoPlayerController
import com.aimicor.typesafenavcompose.videorails.presentation.ui.VideoRailsController
import kotlinx.serialization.Serializable

@Serializable
data object Rails

@Composable
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = Rails
        ) {
            composable<Rails> { VideoRailsController() { navController.navigate(it) } }
            composable<VideoPlayerInfo>(VideoPlayerInfo.typeMap) { VideoPlayerController() }
        }
    }
}
