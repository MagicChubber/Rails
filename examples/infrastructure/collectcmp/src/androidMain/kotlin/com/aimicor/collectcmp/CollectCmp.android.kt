package com.aimicor.collectcmp

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext

@Composable
actual fun <T> StateFlow<T>.collectAsStateWithCmp(
    context: CoroutineContext
): State<T>  = collectAsStateWithLifecycle(
    lifecycleOwner = LocalLifecycleOwner.current,
    minActiveState = Lifecycle.State.STARTED,
    context = context
)


@SuppressLint("ComposableNaming")
@Composable
actual fun <T> Flow<T>.collectWithCmp(
    key: Any?,
    block: (T) -> Unit
) = LocalLifecycleOwner.current.run {
    LaunchedEffect(key) {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            collect { block(it) }
        }
    }
}