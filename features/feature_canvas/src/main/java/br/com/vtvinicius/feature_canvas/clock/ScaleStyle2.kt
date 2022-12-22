package br.com.vtvinicius.feature_canvas.clock

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ScaleStyle2(
    val scaleWidth: Dp = 100.dp,
    val radius: Dp = 550.dp,
    val normalLineColor: Color = Color.LightGray,
    val fiveStepLineColor: Color = Color.Black,
    val tenStepLineColor: Color = Color.Transparent,
    val normalLineLength: Dp = 15.dp,
    val fiveStepLineLength: Dp = 25.dp,
    val tenStepLineLength: Dp = 0.dp,
    val scaleIndicator1Color: Color = Color.Red,
    val scaleIndicator2Color: Color = Color.Black,
    val scaleIndicator3Color: Color = Color.Black,
    val scaleIndicator1Length: Dp = 100.dp,
    val scaleIndicator2Length: Dp = 90.dp,
    val scaleIndicator3Length: Dp = 80.dp,
    val textSize: TextUnit = 18.sp
)