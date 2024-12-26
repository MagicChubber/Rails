package com.aimicor.navcompose.typesafe.examples.infrastructure.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.sunthhumbs.infrastructure.presentation.ui.ShowLoading

@PreviewScreenSizes
@Preview(showBackground = true)
@Composable
private fun ShowLoadingPreview(){
    ShowLoading()
}