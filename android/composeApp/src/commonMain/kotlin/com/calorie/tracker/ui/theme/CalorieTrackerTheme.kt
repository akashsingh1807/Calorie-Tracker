package com.calorie.tracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val rawColorScheme = darkColorScheme(
    primary = Color.Black,
    onPrimary = Color.White,
    primaryContainer = Color.White,
    onPrimaryContainer = Color.Black,
    secondary = Color.White,
    onSecondary = Color.Black,
    secondaryContainer = Color.Black,
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFF0000FF), // Blue for links
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    surfaceVariant = Color(0xFFF0F0F0), // Sunken surface
    onSurfaceVariant = Color.Black,
    error = Color.Red,
    onError = Color.White,
    errorContainer = Color(0xFFCCCCCC),
    onErrorContainer = Color.Black,
    outline = Color.Black
)

@Composable
fun CalorieTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = rawColorScheme, // Force strictly black-on-white regardless of dark mode preference
        typography = rawBlockTypography(),
        shapes = RawBlockShapes,
        content = content
    )
}
