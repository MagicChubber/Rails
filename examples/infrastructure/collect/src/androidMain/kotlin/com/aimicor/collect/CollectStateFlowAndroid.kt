package com.aimicor.collect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext

internal class CollectStateFlowAndroid: CollectStateFlow {

    @Composable
    override fun <T> invoke(
        stateFlow: StateFlow<T>,
        context: CoroutineContext
    ): State<T> = stateFlow.collect(context)

    @Composable
    private fun <T> StateFlow<T>.collect(
        context: CoroutineContext
    ): State<T>  = collectAsStateWithLifecycle(
        lifecycleOwner = LocalLifecycleOwner.current,
        minActiveState = Lifecycle.State.STARTED,
        context = context
    )
}