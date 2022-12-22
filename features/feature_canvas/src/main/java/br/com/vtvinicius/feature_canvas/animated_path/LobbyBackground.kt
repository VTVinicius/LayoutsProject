package br.com.vtvinicius.feature_canvas.animated_path

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StampedPathEffectStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.dp

@Composable
fun LobbyBackground() {
    val infiniteTransition = rememberInfiniteTransition()
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10000f,
        animationSpec = infiniteRepeatable(
            animation = tween(60000, easing = LinearEasing)
        )
    )
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path1 = Path().apply {
            moveTo(-10000f, 100.dp.toPx())
            cubicTo(500.dp.toPx(), 200.dp.toPx(), 300f, 1200f, size.width + 3000f, 200.dp.toPx())
        }
        val path2 = Path().apply {
            moveTo(-10000f, 100.dp.toPx())
            cubicTo(500.dp.toPx(), 2500.dp.toPx(), 300f, 1200f, size.width + 3000f, 2500.dp.toPx())
        }
        val path3 = Path().apply {
            moveTo(-10000f, 100.dp.toPx())
            cubicTo(500.dp.toPx(), 5000.dp.toPx(), 300f, 1200f, size.width + 3000f, 5000.dp.toPx())
        }
        val path4 = Path().apply {
            moveTo(-10000f, 100.dp.toPx())
            cubicTo(500.dp.toPx(), 8000.dp.toPx(), 300f, 1200f, size.width + 3000f, 8000.dp.toPx())
        }
        val star = PathParser()
            .parsePathString("M570.5,252.5l93.8,190c1.5,3.1 4.5,5.3 8,5.8l209.7,30.5c8.7,1.3 12.2,11.9 5.9,18.1L736.1,644.8c-2.5,2.4 -3.6,5.9 -3,9.4L768.8,863c1.5,8.7 -7.6,15.2 -15.4,11.2l-187.5,-98.6c-3.1,-1.6 -6.8,-1.6 -9.9,0l-187.5,98.6c-7.8,4.1 -16.9,-2.5 -15.4,-11.2L389,654.1c0.6,-3.4 -0.5,-6.9 -3,-9.4L234.2,496.9c-6.3,-6.1 -2.8,-16.8 5.9,-18.1l209.7,-30.5c3.4,-0.5 6.4,-2.7 8,-5.8l93.8,-190C555.4,244.7 566.6,244.7 570.5,252.5z")
            .toPath()

        scale(scale = 0.2f) {
            drawPath(
                path = path1,
                color = Color.Magenta,
                style = Stroke(
                    width = 5.dp.toPx(),
                    pathEffect = PathEffect.stampedPathEffect(
                        shape = star,
                        advance = 1000f,
                        phase = -phase * 10f,
                        style = StampedPathEffectStyle.Rotate
                    )
                )
            )
        }
        scale(scale = 0.2f) {
            drawPath(
                path = path2,
                color = Color.Red,
                style = Stroke(
                    width = 5.dp.toPx(),
                    pathEffect = PathEffect.stampedPathEffect(
                        shape = star,
                        advance = 1000f,
                        phase = -phase * 10f,
                        style = StampedPathEffectStyle.Rotate
                    )
                )
            )
        }
        scale(scale = 0.2f) {
            drawPath(
                path = path3,
                color = Color.Blue,
                style = Stroke(
                    width = 5.dp.toPx(),
                    pathEffect = PathEffect.stampedPathEffect(
                        shape = star,
                        advance = 1000f,
                        phase = -phase * 10f,
                        style = StampedPathEffectStyle.Rotate
                    )
                )
            )
        }

        scale(scale = 0.2f) {
            drawPath(
                path = path4,
                color = Color.Green,
                style = Stroke(
                    width = 5.dp.toPx(),
                    pathEffect = PathEffect.stampedPathEffect(
                        shape = star,
                        advance = 1000f,
                        phase = -phase * 10f,
                        style = StampedPathEffectStyle.Rotate
                    )
                )
            )
        }

    }
}