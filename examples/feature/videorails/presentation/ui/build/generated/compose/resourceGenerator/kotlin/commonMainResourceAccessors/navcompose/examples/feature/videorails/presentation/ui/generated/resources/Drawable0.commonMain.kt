@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package navcompose.examples.feature.videorails.presentation.ui.generated.resources

import kotlin.OptIn
import org.jetbrains.compose.resources.DrawableResource

private object CommonMainDrawable0 {
  public val placeholder_landscape: DrawableResource by 
      lazy { init_placeholder_landscape() }
}

internal val Res.drawable.placeholder_landscape: DrawableResource
  get() = CommonMainDrawable0.placeholder_landscape

private fun init_placeholder_landscape(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:placeholder_landscape",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/navcompose.examples.feature.videorails.presentation.ui.generated.resources/drawable/placeholder_landscape.xml", -1, -1),
    )
)
