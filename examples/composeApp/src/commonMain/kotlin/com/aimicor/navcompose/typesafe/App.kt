package com.aimicor.navcompose.typesafe

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aimicor.typesafenavcompose.videorails.presentation.ui.VideoRailsController
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinx.serialization.Serializable

@Serializable
data object Home

@Composable
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = Home
        ) {
            composable<Home> { VideoRailsController() }
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
