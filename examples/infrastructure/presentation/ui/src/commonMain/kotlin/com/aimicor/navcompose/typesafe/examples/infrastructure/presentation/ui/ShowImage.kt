package com.aimicor.navcompose.typesafe.examples.infrastructure.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import navcompose.examples.infrastructure.presentation.ui.generated.resources.Res
import navcompose.examples.infrastructure.presentation.ui.generated.resources.placeholder_landscape
import org.jetbrains.compose.resources.painterResource

@Composable
fun ShowImage(
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = modifier,
        painter = painterResource(Res.drawable.placeholder_landscape),
        contentDescription = null,
    )
}
