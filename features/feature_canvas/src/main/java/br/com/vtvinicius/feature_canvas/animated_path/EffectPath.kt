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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StampedPathEffectStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.dp

@Composable
fun EffectPath() {

    val infiniteTransition = rememberInfiniteTransition()
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10000f,
        animationSpec = infiniteRepeatable(
            animation = tween(60000, easing = LinearEasing)
        )
    )
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(0.dp.toPx(), 50.dp.toPx())
            lineTo(1000.dp.toPx(), 50.dp.toPx())
        }
        val oval1 = Path().apply {
            addOval(
                Rect(
                    topLeft = Offset(
                        100f, 300f
                    ), bottomRight = Offset(400f, 500f)
                )
            )
        }
        val path2 = Path().apply {
            moveTo(-10000f, 800f)
            cubicTo(1000f, 800f, 300f, 1200f, size.width + 3000f, 4000f)
        }
        val star = PathParser()
            .parsePathString("M570.5,252.5l93.8,190c1.5,3.1 4.5,5.3 8,5.8l209.7,30.5c8.7,1.3 12.2,11.9 5.9,18.1L736.1,644.8c-2.5,2.4 -3.6,5.9 -3,9.4L768.8,863c1.5,8.7 -7.6,15.2 -15.4,11.2l-187.5,-98.6c-3.1,-1.6 -6.8,-1.6 -9.9,0l-187.5,98.6c-7.8,4.1 -16.9,-2.5 -15.4,-11.2L389,654.1c0.6,-3.4 -0.5,-6.9 -3,-9.4L234.2,496.9c-6.3,-6.1 -2.8,-16.8 5.9,-18.1l209.7,-30.5c3.4,-0.5 6.4,-2.7 8,-5.8l93.8,-190C555.4,244.7 566.6,244.7 570.5,252.5z")
            .toPath()
        drawPath(
            path = oval1,
            color = Color.Red,
            style = Stroke(
                width = 5.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(50f, 30f),
                    phase = phase
                )
            )
        )
        drawPath(
            path = path,
            color = Color.Red,
            style = Stroke(
                width = 5.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(50f, 30f),
                    phase = phase
                )
            )
        )
        scale(scale = 0.1f) {
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

    }
}