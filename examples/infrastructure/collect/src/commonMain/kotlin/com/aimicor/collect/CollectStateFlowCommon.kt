package com.aimicor.collect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext

internal class CollectStateFlowCommon : CollectStateFlow {

    @Composable
    override fun <T> invoke(
        stateFlow: StateFlow<T>,
        context: CoroutineContext
    ) = stateFlow.collect(context)

    @Composable
    private fun <T> StateFlow<T>.collect(
        context: CoroutineContext
    ): State<T> = collectAsState(context)
}
