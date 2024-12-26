@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package navcompose.examples.infrastructure.presentation.ui.generated.resources

import kotlin.OptIn
import org.jetbrains.compose.resources.StringResource

private object CommonMainString0 {
  public val error: StringResource by 
      lazy { init_error() }

  public val retry: StringResource by 
      lazy { init_retry() }
}

internal val Res.string.error: StringResource
  get() = CommonMainString0.error

private fun init_error(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:error", "error",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/navcompose.examples.infrastructure.presentation.ui.generated.resources/values/strings.commonMain.cvr",
    10, 21),
    )
)

internal val Res.string.retry: StringResource
  get() = CommonMainString0.retry

private fun init_retry(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:retry", "retry",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/navcompose.examples.infrastructure.presentation.ui.generated.resources/values/strings.commonMain.cvr",
    32, 21),
    )
)
