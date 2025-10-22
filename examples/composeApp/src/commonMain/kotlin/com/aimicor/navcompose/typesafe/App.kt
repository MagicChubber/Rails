package com.aimicor.navcompose.typesafe

import androidx.compose.material.MaterialTheme
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
            composable<Rails> { VideoRailsController() }
            composable<VideoPlayerInfo> { VideoPlayerController() }
        }
    }
}

//NavHost(
//modifier = Modifier.padding(innerPadding),
//navController = scaffoldNavController,
//startDestination = NavRoute(
//title = stringResource(R.string.home),
//selectedVideo = homeVideoSelect,
//videoList = homeVideoList
//)
//) {
//    composable<NavRoute>(navRouteTypes) { ScreenContent() }
//}
