package com.aimicor.collect

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow

internal class CollectFlowAndroid : CollectFlow {

    @Composable
    override fun <T> invoke(
        flow: Flow<T>,
        key: Any?,
        block: (T) -> Unit
    ) = flow.collect(key, block)

    @SuppressLint("ComposableNaming")
    @Composable
    fun <T> Flow<T>.collect(
        key: Any?,
        block: (T) -> Unit
    ) = LocalLifecycleOwner.current.run {
        LaunchedEffect(key) {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                collect { block(it) }
            }
        }
    }
}
