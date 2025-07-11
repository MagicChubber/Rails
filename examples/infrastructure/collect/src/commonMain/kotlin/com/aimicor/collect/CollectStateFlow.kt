package com.aimicor.collect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import kotlinx.coroutines.flow.StateFlow
import org.koin.mp.KoinPlatformTools
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

interface CollectStateFlow {

    @Composable
    operator fun <T> invoke(
        stateFlow: StateFlow<T>,
        context: CoroutineContext
    ): State<T>
}

@Composable
fun <T> StateFlow<T>.collectStateFlow(
    context: CoroutineContext = EmptyCoroutineContext,
    collectStateFlow: CollectStateFlow = KoinPlatformTools.defaultContext().get().get()
): State<T> = collectStateFlow(this, context)