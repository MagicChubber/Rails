package com.aimicor.collect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow

internal class CollectFlowCommon : CollectFlow {

    @Composable
    override fun <T> invoke(
        flow: Flow<T>,
        key: Any?,
        block: (T) -> Unit
    ) = flow.collect(key, block)

    @Composable
    private fun <T> Flow<T>.collect(
        key: Any?,
        block: (T) -> Unit
    ) = LaunchedEffect(key) { collect { block(it) } }
}
