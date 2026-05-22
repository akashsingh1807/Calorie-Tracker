package com.calorie.tracker.ui.theme

import androidx.compose.ui.graphics.Color

// Flip7 Teal
val PrimaryTeal = Color(0xFF2BA8A2)
val PrimaryLight = Color(0xFF3CC4BD)
val PrimaryDark = Color(0xFF1E8C86)
val PrimaryBG = Color(0xFFE8F6F5)

// Flip7 Gold
val AccentGold = Color(0xFFFFD23F)
val AccentLight = Color(0xFFFFE47A)
val AccentDark = Color(0xFFE6B800)

// Flip7 Coral
val CoralPrimary = Color(0xFFEF6C4A)
val CoralLight = Color(0xFFFF8A6A)
val CoralDark = Color(0xFFD45233)

// Other Flip7 Colors
val CreamSurface = Color(0xFFFFF8E7)
val SkyBlue = Color(0xFF5DADE2)
val SurfaceBase = Color(0xFFEFF8F7)
val SurfaceCard = Color(0xFFFFFFFF)

// Semantic Colors
val SuccessColor = Color(0xFF27AE60)
val ErrorColor = Color(0xFFE74C3C)
val WarningColor = AccentGold
val InfoColor = SkyBlue

// Light Mode mappings
val md_theme_light_primary = PrimaryTeal
val md_theme_light_onPrimary = Color.White
val md_theme_light_secondary = CoralPrimary
val md_theme_light_onSecondary = Color.White
val md_theme_light_tertiary = AccentGold
val md_theme_light_onTertiary = Color.Black
val md_theme_light_background = SurfaceBase
val md_theme_light_onBackground = Color(0xFF1E293B)
val md_theme_light_surface = SurfaceCard
val md_theme_light_onSurface = Color(0xFF334155)
val md_theme_light_error = ErrorColor
val md_theme_light_onError = Color.White

// Dark Mode mappings (Flip7 usually doesn't have a distinct dark mode, but keeping same scheme)
val md_theme_dark_primary = PrimaryLight
val md_theme_dark_onPrimary = PrimaryDark
val md_theme_dark_secondary = CoralLight
val md_theme_dark_onSecondary = CoralDark
val md_theme_dark_tertiary = AccentLight
val md_theme_dark_onTertiary = AccentDark
val md_theme_dark_background = Color(0xFF0F172A)
val md_theme_dark_onBackground = Color(0xFFF1F5F9)
val md_theme_dark_surface = Color(0xFF1E293B)
val md_theme_dark_onSurface = Color(0xFFF8FAFC)
val md_theme_dark_error = ErrorColor
val md_theme_dark_onError = Color.White
