package com.aimicor.collectcmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import kotlinx.
coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@Composable
expect fun <T> StateFlow<T>.collectAsStateWithCmp(
    context: CoroutineContext = EmptyCoroutineContext
): State<T>

@Composable
expect fun <T> Flow<T>.collectWithCmp(
    key: Any? = true,
    block: (T) -> Unit
)