package br.com.vtvinicius.uikit.base

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.vtvinicius.uikit.R


private val arialRegular = FontFamily(
    Font(R.font.arial_regular, FontWeight.Normal)
)
private val arialBold = FontFamily(
    Font(R.font.arial_bold, FontWeight.Bold)
)

data class AppTypography(

    val displayLarge: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp
    ),
    val displayMedium: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp
    ),
    val displaySmall: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),

    val headlineLarge: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    val headlineMedium: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    val headlineSmall: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),

    val titleLarge: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    val titleMedium: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    val titleSmall: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),

    val labelLarge: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    val labelMedium: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    val labelSmall: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp
    ),

    val bodyLarge: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    val bodySmall: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }