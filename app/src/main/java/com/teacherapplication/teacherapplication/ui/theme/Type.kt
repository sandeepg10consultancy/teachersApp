package com.teacherapplication.teacherapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.teacherapplication.teacherapplication.R

val fonts = FontFamily(
    Font(R.font.font_regular),
    Font(R.font.font_medium, FontWeight.W500),
    Font(R.font.font_semi_bold, FontWeight.SemiBold),
    Font(R.font.font_bold, FontWeight.Bold),
    Font(R.font.font_extra_bold, FontWeight.ExtraBold),
)

val italicSansFont = FontFamily(
    Font(R.font.font_italic, FontWeight(400))
)

val italicJost = FontFamily(
    Font(R.font.jost_italic, FontWeight(400))
)

val jostFont = FontFamily(
    Font(R.font.jost_regular),
    Font(R.font.jost_medium, FontWeight.W500),
    Font(R.font.jost_black),
    Font(R.font.jost_bold, FontWeight.Bold),
    Font(R.font.jost_extra_bold, FontWeight.ExtraBold),
)

val openFont = FontFamily(
    Font(R.font.open_sans_regular),
    Font(R.font.open_sans_medium, FontWeight.Normal),
    Font(R.font.open_sans_bold, FontWeight.Bold),
    Font(R.font.open_sans_extra_bold, FontWeight.ExtraBold),
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight(600),
        fontSize = 18.sp,
        lineHeight = 22.68.sp,
        letterSpacing = 0.3.sp
    ),
    bodySmall = TextStyle(
        fontFamily = fonts,
        fontSize = 16.sp,
        lineHeight = 20.16.sp,
        fontWeight = FontWeight(400)
    ),
    labelMedium = TextStyle(
        fontFamily = fonts,
        fontSize = 14.sp,
        lineHeight = 17.64.sp,
        fontWeight = FontWeight(400)
    ),
    labelLarge = TextStyle(
        fontFamily = fonts,
        fontSize = 20.sp,
        lineHeight = 25.2.sp,
        fontWeight = FontWeight(700)
    ),
    labelSmall = TextStyle(
        fontFamily = fonts,
        fontSize = 12.sp,
        fontWeight = FontWeight(400),
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = jostFont,
        fontWeight = FontWeight(700),
        fontSize = 25.sp,
        lineHeight = 36.13.sp
    ),
    titleMedium = TextStyle(
        fontFamily = jostFont,
        fontWeight = FontWeight(600),
        fontSize = 18.sp,
        lineHeight = 26.01.sp,
        color = Color(0xFF1D1751)
    ),
    bodyMedium = TextStyle(
        fontFamily = openFont,
        fontWeight = FontWeight(700),
        fontSize = 14.sp,
        lineHeight = 16.8.sp,
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)