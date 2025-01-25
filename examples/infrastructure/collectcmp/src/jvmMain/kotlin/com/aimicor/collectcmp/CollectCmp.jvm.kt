package com.aimicor.collectcmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext

@Composable
actual fun <T> StateFlow<T>.collectAsStateWithCmp(
    context: CoroutineContext
): State<T>  = collectAsState(context)

@Composable
actual fun <T> Flow<T>.collectWithCmp(
    key: Any?,
    block: (T) -> Unit
) = LaunchedEffect(key) { collect { block(it) } }
