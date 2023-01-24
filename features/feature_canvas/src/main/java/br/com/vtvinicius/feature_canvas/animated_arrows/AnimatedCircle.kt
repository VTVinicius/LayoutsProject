package br.com.vtvinicius.feature_canvas.animated_arrows
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AnimatedCircle() {
    val pathPortion = remember {
        Animatable(initialValue = 0f)
    }


    LaunchedEffect(key1 = true) {
        delay(2800)
        pathPortion.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 2000
            )
        )
    }



    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
    ) {

        val path = Path().apply {
            addOval(Rect(Offset(200.dp.toPx(),500.dp.toPx()), 70.dp.toPx()))
        }

        val outPath = Path()
        PathMeasure().apply {
            setPath(path, false)
            getSegment(0f, pathPortion.value * length, outPath, true)
        }

        drawPath(
            path = outPath,
            color = Color.Blue,
            style = Stroke(width = 2.dp.toPx())
        )
    }
}