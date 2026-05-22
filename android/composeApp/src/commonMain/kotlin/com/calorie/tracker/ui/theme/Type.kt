package com.calorie.tracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun getFlip7Typography(): Typography {
    return Typography(
        // h1: Game titles
        displayLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.ExtraBold, 
            fontSize = 36.sp, // 72rpx display
            lineHeight = 44.sp,
            letterSpacing = 2.sp
        ),
        // h2: Section titles
        displayMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp, // 48rpx h1
            lineHeight = 32.sp,
            letterSpacing = 1.sp
        ),
        // h3: Card titles
        headlineLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp, // 36rpx h2
            lineHeight = 26.sp
        ),
        // h4: Sub-headings
        headlineMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp, // 32rpx h3
            lineHeight = 24.sp
        ),
        // body: Instructions
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp, // 28rpx body
            lineHeight = 20.sp
        ),
        // sm: Labels
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp, // 24rpx sm
            lineHeight = 16.sp
        ),
        // xs: Badges
        labelSmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp, // 20rpx xs
            lineHeight = 14.sp
        )
    )
}
