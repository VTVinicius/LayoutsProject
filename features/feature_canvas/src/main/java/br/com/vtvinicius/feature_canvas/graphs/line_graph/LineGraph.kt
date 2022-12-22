package br.com.vtvinicius.feature_canvas.graphs.line_graph

import android.content.res.Configuration
import android.graphics.Paint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.atan2

@Composable
fun LineGraph(
    modifier: Modifier = Modifier,
    pointsList: MutableList<Points> = mutableListOf(),
) {



    val leftSide = 70.dp

    XLine(leftSide = leftSide)
    YLine(leftSide = leftSide)
    GraphLines(leftSide = leftSide, pointsList = pointsList)
    BackAndSideLines(pointsList = pointsList, leftSide = leftSide)

}

@Composable
fun XLine(leftSide: Dp) {

    val pathPortionX = remember {
        Animatable(initialValue = 0f)
    }

    var centerY by remember {
        mutableStateOf(0.dp)
    }

    LaunchedEffect(key1 = true) {
        pathPortionX.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 3000
            )
        )
    }

    Canvas(modifier = Modifier.fillMaxSize().padding(end = 20.dp)) {
        val pathX = Path().apply {
            moveTo(leftSide.toPx(), center.y.dp.toPx())
            lineTo((center.x + center.x), center.y.dp.toPx())
        }
        val outPathX = android.graphics.Path()
        val posX = FloatArray(2)
        val tanX = FloatArray(2)
        android.graphics.PathMeasure().apply {
            setPath(pathX.asAndroidPath(), false)
            getSegment(0f, pathPortionX.value * length, outPathX, true)
            getPosTan(pathPortionX.value * length, posX, tanX)
        }

        drawPath(
            path = outPathX.asComposePath(),
            color = Color.Red,
            style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
        )

        val xX = posX[0]
        val yX = posX[1]
        val degreesX = -atan2(tanX[0], tanX[1]) * (180f / PI.toFloat()) - 180f
        rotate(degrees = degreesX, pivot = Offset(xX, yX)) {
            drawPath(
                path = Path().apply {
                    moveTo(xX, yX - 15f)
                    lineTo(xX - 15f, yX + 30f)
                    lineTo(xX + 15f, yX + 30f)
                    close()
                },
                color = Color.Red
            )
        }
    }
}

@Composable
fun YLine(leftSide: Dp) {

    val pathPortionY = remember {
        Animatable(initialValue = 0f)
    }

    LaunchedEffect(key1 = true) {
        pathPortionY.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 3000
            )
        )
    }

    Canvas(modifier = Modifier.fillMaxHeight().padding(top = 20.dp, bottom = 2.dp)) {

        val pathY = Path().apply {
            moveTo(leftSide.toPx(), center.y.dp.toPx())
            lineTo(leftSide.toPx(), size.height - size.height)
        }
        val outPathY = android.graphics.Path()
        val posY = FloatArray(2)
        val tanY = FloatArray(2)
        android.graphics.PathMeasure().apply {
            setPath(pathY.asAndroidPath(), false)
            getSegment(0f, pathPortionY.value * length, outPathY, true)
            getPosTan(pathPortionY.value * length, posY, tanY)
        }


        drawPath(
            path = outPathY.asComposePath(),
            color = Color.Red,
            style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
        )

        val xY = posY[0]
        val yY = posY[1]
        val degrees = -atan2(tanY[0], tanY[1]) * (180f / PI.toFloat()) - 180f
        rotate(degrees = degrees, pivot = Offset(xY, yY)) {
            drawPath(
                path = Path().apply {
                    moveTo(xY, yY - 15f)
                    lineTo(xY - 15f, yY + 30f)
                    lineTo(xY + 15f, yY + 30f)
                    close()
                },
                color = Color.Red
            )
        }

    }


}

@Composable
fun GraphLines(pointsList: MutableList<Points>, leftSide: Dp) {


    val pathPortionLines = remember {
        Animatable(initialValue = 0f)
    }

    LaunchedEffect(key1 = true) {
        pathPortionLines.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 3000
            )
        )
    }

    val configuration = LocalConfiguration.current



    //draw the Lines of the Graph
    Canvas(modifier = Modifier.fillMaxSize()) {

        val calcSpaceBetweenLines = (size.width - leftSide.toPx()) / pointsList.size

        val pathLines = Path().apply {
            moveTo(leftSide.toPx(), pointsList.first().valueY.dp.toPx())
            for (i in 0..pointsList.size - 1) {
                val isLastItem = i == pointsList.size - 1
                val isFirstItem = i == 0
                lineTo(
                    x =
                    when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            when {
                                isFirstItem -> calcSpaceBetweenLines + calcSpaceBetweenLines + calcSpaceBetweenLines
                                isLastItem -> calcSpaceBetweenLines * (i + 2)
                                else -> calcSpaceBetweenLines + calcSpaceBetweenLines * (i + 2)
                            }
                        } else -> {
                        when {
                            isFirstItem -> calcSpaceBetweenLines + calcSpaceBetweenLines
                            isLastItem -> calcSpaceBetweenLines * (i + 1)
                            else -> calcSpaceBetweenLines + calcSpaceBetweenLines * (i + 1)
                        }
                    }
                    },

                    y = pointsList[if (isLastItem) i else i + 1].valueY.dp.toPx()
                )
            }
        }
        val outPathLines = android.graphics.Path()
        val posY = FloatArray(2)
        val tanY = FloatArray(2)
        android.graphics.PathMeasure().apply {
            setPath(pathLines.asAndroidPath(), false)
            getSegment(0f, pathPortionLines.value * length, outPathLines, true)
            getPosTan(pathPortionLines.value * length, posY, tanY)
        }



        drawPath(
            path = outPathLines.asComposePath(),
            color = Color.Green,
            style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
        )


    }

}


@Composable
fun BackAndSideLines(
    pointsList: MutableList<Points> = mutableListOf(),
    leftSide: Dp
) {


    val pathPortionSideLines = remember {
        Animatable(initialValue = 0f)
    }



    LaunchedEffect(key1 = true) {
        pathPortionSideLines.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1500
            )
        )
    }

    //Draw the background lines and the side liones
    Canvas(modifier = Modifier.fillMaxSize()) {

        for (i in 0..pointsList.size - 1) {
            if ((40 * (i + 1) < center.y)) {

                val pathSideLines = Path().apply {
                    moveTo(leftSide.toPx(), (40 * (i + 1)).dp.toPx())
                    lineTo((center.x + center.x - 20), (40 * (i + 1)).dp.toPx())
                }

                val outPathSideLines = android.graphics.Path()
                val posSideY = FloatArray(2)
                val tanSideY = FloatArray(2)
                android.graphics.PathMeasure().apply {
                    setPath(pathSideLines.asAndroidPath(), false)
                    getSegment(0f, pathPortionSideLines.value * length, outPathSideLines, true)
                    getPosTan(pathPortionSideLines.value * length, posSideY, tanSideY)
                }
                drawContext.canvas.nativeCanvas.apply {
                    drawText(
                        "${40 * (i + 1)}",
                        20.dp.toPx(),
                        ((40 * (i + 1)) + 5).dp.toPx(),
                        Paint().apply {
                            color = android.graphics.Color.RED
                            textSize = 14.dp.toPx()
                        },
                    )

                    drawPath(
                        path = outPathSideLines.asComposePath(),
                        color = Color.Gray,
                        style = Stroke(width = 1.dp.toPx(), cap = StrokeCap.Round)
                    )
                }
            }
        }
    }

}


@Preview
@Composable
fun LineGraphPreview() {
    LineGraph()
}