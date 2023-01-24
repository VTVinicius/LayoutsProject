package br.com.vtvinicius.feature_canvas.animated_arrows

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.atan2

@Composable
fun AnimatedArrow() {
    val pathPortion = remember {
        Animatable(initialValue = 0f)
    }
    LaunchedEffect(key1 = true) {
        pathPortion.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 3000
            )
        )
    }

    Canvas(modifier = Modifier.fillMaxSize()) {

        val path = Path().apply {
            moveTo(50.dp.toPx(), 50.dp.toPx())
            quadraticBezierTo(500.dp.toPx(), 400.dp.toPx(), 300.dp.toPx(), 450.dp.toPx())
        }
        val outPath = android.graphics.Path()
        val pos = FloatArray(2)
        val tan = FloatArray(2)
        android.graphics.PathMeasure().apply {
            setPath(path.asAndroidPath(), false)
            getSegment(0f, pathPortion.value * length, outPath, true)
            getPosTan(pathPortion.value * length, pos, tan)
        }


        drawPath(
            path = outPath.asComposePath(),
            color = Color.Red,
            style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
        )


        val x = pos[0]
        val y = pos[1]
        val degrees = -atan2(tan[0], tan[1]) * (180f / PI.toFloat()) - 180f
        rotate(degrees = degrees, pivot = Offset(x, y)) {
            drawPath(
                path = Path().apply {
                    moveTo(x, y - 30f)
                    lineTo(x - 30f, y + 60f)
                    lineTo(x + 30f, y + 60f)
                    close()
                },
                color = Color.Red
            )
        }
    }
}


