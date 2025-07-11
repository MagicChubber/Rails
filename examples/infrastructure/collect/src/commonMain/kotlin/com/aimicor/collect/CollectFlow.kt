package com.aimicor.collect

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow
import org.koin.mp.KoinPlatformTools

interface CollectFlow {

    @Composable
    operator fun <T> invoke(
        flow: Flow<T>,
        key: Any? = null,
        block: (T) -> Unit
    )
}

@Composable
fun <T> Flow<T>.collectFlow(
    key: Any? = null,
    collectFlow: CollectFlow = KoinPlatformTools.defaultContext().get().get(),
    block: (T) -> Unit
) = collectFlow(this, key, block)
