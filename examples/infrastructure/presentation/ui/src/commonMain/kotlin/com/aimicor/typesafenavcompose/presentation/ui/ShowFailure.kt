package com.aimicor.typesafenavcompose.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import navcompose.examples.infrastructure.presentation.ui.generated.resources.Res
import navcompose.examples.infrastructure.presentation.ui.generated.resources.baseline_close_24
import navcompose.examples.infrastructure.presentation.ui.generated.resources.baseline_error_outline_24
import navcompose.examples.infrastructure.presentation.ui.generated.resources.error
import navcompose.examples.infrastructure.presentation.ui.generated.resources.retry
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShowFailure(
    message: String,
    onClose: () -> Unit,
    onRetry: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(onClick = { onClose()}) {
            Icon(
                painter = painterResource(Res.drawable.baseline_close_24),
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(Res.string.error),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp
            )
            Icon(
                modifier = Modifier.size(64.dp),
                painter = painterResource(Res.drawable.baseline_error_outline_24),
                tint = Color.Red,
                contentDescription = null
            )
            Text(
                modifier = Modifier.width(200.dp),
                color = MaterialTheme.colorScheme.onBackground,
                text = message,
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )
            Button(onClick = { onRetry() }) {
                Text(stringResource(Res.string.retry))
            }
        }
    }
}

@Preview
@Composable
private fun ShowFailurePreview() {
    ShowFailure("Failed", {}, {})
}
