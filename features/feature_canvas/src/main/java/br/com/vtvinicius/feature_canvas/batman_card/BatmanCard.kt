package br.com.vtvinicius.feature_canvas.batman_card

import android.graphics.Paint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import br.com.vtvinicius.uikit.R
import kotlinx.coroutines.delay

@Composable
fun BatmanCard(
) {


    var totalComplete by remember {
        mutableStateOf(0)
    }

    var repeatble by remember {
        mutableStateOf(0)
    }
    val batString = stringResource(id = R.string.bat_logo)

    val batPath = remember {
        PathParser().parsePathString(batString).toPath()
    }

    val batPathBounds = remember {
        batPath.getBounds()
    }

    LaunchedEffect(key1 = repeatble) {
        for (i in 0..98) {
            delay(100L)
            totalComplete++
        }
        totalComplete = 0
        repeatble++
    }


    val maxRadius = max(batPathBounds.maxDimension.dp, batPathBounds.maxDimension.dp) / 2
    val currentRadius = (totalComplete.plus(1)) / 170f * maxRadius

    val currentRadiusAnimated = animateDpAsState(
        targetValue = currentRadius,
        animationSpec = tween(durationMillis = 60)

    )



    BoxWithConstraints(
        modifier = Modifier
            .size(150.dp, 60.dp)
            .drawBehind {
                drawPath(
                    path = batPath,
                    color = Color.LightGray,
                )
                clipPath(
                    path = batPath
                ) {
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color.Black,
                                Color.Black
                            ),
                            center = batPathBounds.center,
                            radius = currentRadiusAnimated.value.toPx()
                        ),
                        radius = currentRadiusAnimated.value.toPx(),
                        center = batPathBounds.center
                    )

                }

                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        "${totalComplete} %",
                        batPathBounds.center.x,
                        batPathBounds.center.y,
                        Paint().apply {
                            textSize = 20.sp.toPx()
                            textAlign = Paint.Align.CENTER
                            color = Color.Yellow.toArgb()
                        }
                    )
                }
            }
    ) {

    }
}