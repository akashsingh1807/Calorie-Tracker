@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package calorietracker.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.FontResource
import org.jetbrains.compose.resources.InternalResourceApi

private object CommonMainFont0 {
  public val archivo_black: FontResource by 
      lazy { init_archivo_black() }

  public val space_mono: FontResource by 
      lazy { init_space_mono() }

  public val work_sans_regular: FontResource by 
      lazy { init_work_sans_regular() }
}

@InternalResourceApi
internal fun _collectCommonMainFont0Resources(map: MutableMap<String, FontResource>) {
  map.put("archivo_black", CommonMainFont0.archivo_black)
  map.put("space_mono", CommonMainFont0.space_mono)
  map.put("work_sans_regular", CommonMainFont0.work_sans_regular)
}

internal val Res.font.archivo_black: FontResource
  get() = CommonMainFont0.archivo_black

private fun init_archivo_black(): FontResource = org.jetbrains.compose.resources.FontResource(
  "font:archivo_black",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/calorietracker.composeapp.generated.resources/font/archivo_black.ttf", -1, -1),
    )
)

internal val Res.font.space_mono: FontResource
  get() = CommonMainFont0.space_mono

private fun init_space_mono(): FontResource = org.jetbrains.compose.resources.FontResource(
  "font:space_mono",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/calorietracker.composeapp.generated.resources/font/space_mono.ttf", -1, -1),
    )
)

internal val Res.font.work_sans_regular: FontResource
  get() = CommonMainFont0.work_sans_regular

private fun init_work_sans_regular(): FontResource = org.jetbrains.compose.resources.FontResource(
  "font:work_sans_regular",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/calorietracker.composeapp.generated.resources/font/work_sans_regular.ttf", -1, -1),
    )
)
