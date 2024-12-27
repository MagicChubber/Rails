package com.aimicor.navcompose.typesafe.appwith

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.aimicor.navcompose.typesafe.appwith.videorails.VideoRailsAppWithViewModel
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state.VideoRailsController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { VideoRailsController(hiltViewModel<VideoRailsAppWithViewModel>()) }
    }
}
