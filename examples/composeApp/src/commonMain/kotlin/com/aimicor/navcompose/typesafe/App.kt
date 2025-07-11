package com.aimicor.navcompose.typesafe

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.ui.VideoRailsController
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        VideoRailsController()
    }
}