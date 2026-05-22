package com.calorie.tracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import calorietracker.composeapp.generated.resources.*
import calorietracker.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun getArchivoBlack(): FontFamily {
    return FontFamily(
        Font(Res.font.archivo_black, FontWeight.Normal)
    )
}

@Composable
fun getWorkSans(): FontFamily {
    return FontFamily(
        Font(Res.font.work_sans_regular, FontWeight.Normal)
    )
}

@Composable
fun getSpaceMono(): FontFamily {
    return FontFamily(
        Font(Res.font.space_mono, FontWeight.Normal)
    )
}

@Composable
fun rawBlockTypography(): Typography {
    val archivoBlack = getArchivoBlack()
    val workSans = getWorkSans()
    
    return Typography(
        displayLarge = TextStyle(
            fontFamily = archivoBlack,
            fontWeight = FontWeight.Normal,
            fontSize = 64.sp,
            lineHeight = 64.sp,
            letterSpacing = 0.sp
        ),
        displayMedium = TextStyle(
            fontFamily = archivoBlack,
            fontWeight = FontWeight.Normal,
            fontSize = 48.sp,
            lineHeight = 50.4.sp, // 1.05
            letterSpacing = 0.sp
        ),
        displaySmall = TextStyle(
            fontFamily = archivoBlack,
            fontWeight = FontWeight.Normal,
            fontSize = 32.sp,
            lineHeight = 35.2.sp, // 1.1
            letterSpacing = 0.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = workSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            lineHeight = 26.4.sp, // 1.2
            letterSpacing = 0.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = workSans,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 25.6.sp, // 1.6
            letterSpacing = 0.5.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = workSans,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 21.sp, // 1.5
            letterSpacing = 0.sp
        ),
        bodySmall = TextStyle(
            fontFamily = workSans,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.8.sp, // 1.4
            letterSpacing = 0.sp
        )
    )
}
