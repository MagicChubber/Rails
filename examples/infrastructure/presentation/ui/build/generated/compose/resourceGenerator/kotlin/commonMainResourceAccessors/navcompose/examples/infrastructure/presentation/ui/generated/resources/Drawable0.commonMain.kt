@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package navcompose.examples.infrastructure.presentation.ui.generated.resources

import kotlin.OptIn
import org.jetbrains.compose.resources.DrawableResource

private object CommonMainDrawable0 {
  public val baseline_close_24: DrawableResource by 
      lazy { init_baseline_close_24() }

  public val baseline_error_outline_24: DrawableResource by 
      lazy { init_baseline_error_outline_24() }
}

internal val Res.drawable.baseline_close_24: DrawableResource
  get() = CommonMainDrawable0.baseline_close_24

private fun init_baseline_close_24(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:baseline_close_24",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/navcompose.examples.infrastructure.presentation.ui.generated.resources/drawable/baseline_close_24.xml", -1, -1),
    )
)

internal val Res.drawable.baseline_error_outline_24: DrawableResource
  get() = CommonMainDrawable0.baseline_error_outline_24

private fun init_baseline_error_outline_24(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:baseline_error_outline_24",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/navcompose.examples.infrastructure.presentation.ui.generated.resources/drawable/baseline_error_outline_24.xml", -1, -1),
    )
)
