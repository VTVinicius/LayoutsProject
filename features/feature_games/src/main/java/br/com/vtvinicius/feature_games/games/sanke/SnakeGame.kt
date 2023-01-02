package br.com.vtvinicius.feature_games.games.sanke

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun SnakeGameScreen() {

    var points by remember {
        mutableStateOf(0)
    }

    BallClicker(
        enabled = true,
        onBallTrigger = {
            points++
        },
        points = points
    )

}


@Composable
fun BallClicker(
    radius: Float =
        30f,
    enabled: Boolean = true,
    ballColor: Color = Color.Red,
    onBallTrigger: () -> Unit = {},
    points: Int = 0
) {


    var isGoingUp by remember {
        mutableStateOf(Directions().isGoingUp)
    }
    var isGoingDown by remember {
        mutableStateOf(Directions().isGoingDown)
    }
    var isGoingLeft by remember {
        mutableStateOf(Directions().isGoingLeft)
    }
    var isGoingRight by remember {
        mutableStateOf(Directions().isGoingRight)
    }

    var offset by remember {
        mutableStateOf(Offset(400f, 400f))
    }

    var maxHeigth by remember {
        mutableStateOf(1000f)
    }

    var maxWidth by remember {
        mutableStateOf(1000f)
    }

    var ballPosition by remember {
        mutableStateOf(
            randomOffset(
                radius = radius,
                width = maxWidth.toInt(),
                height = maxHeigth.toInt()
            )
        )
    }

    val delayTime: Long = 500

    val newOffset by animateOffsetAsState(
        targetValue = offset,
        tween(
            durationMillis = (delayTime / 2).toInt()
        )
    )

    Column(Modifier.fillMaxSize()) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {

            Button(onClick = {
                isGoingUp = true
                isGoingDown = false
                isGoingLeft = false
                isGoingRight = false
                offset = snakeMovement(
                    isGoingUp = isGoingUp,
                    isGoingDown = isGoingDown,
                    isGoingLeft = isGoingLeft,
                    isGoingRight = isGoingRight,
                    offset = offset,
                    maxHeigth = maxHeigth,
                    maxWidth = maxWidth,
                    radius = radius
                )
            }) {
                Text(text = "UP")
            }
            Button(onClick = {
                isGoingUp = false
                isGoingDown = true
                isGoingLeft = false
                isGoingRight = false
                offset = snakeMovement(
                    isGoingUp = isGoingUp,
                    isGoingDown = isGoingDown,
                    isGoingLeft = isGoingLeft,
                    isGoingRight = isGoingRight,
                    offset = offset,
                    maxHeigth = maxHeigth,
                    maxWidth = maxWidth,
                    radius = radius
                )
            }) {
                Text(text = "Down")
            }
            Button(onClick = {
                isGoingUp = false
                isGoingDown = false
                isGoingLeft = true
                isGoingRight = false
                offset = snakeMovement(
                    isGoingUp = isGoingUp,
                    isGoingDown = isGoingDown,
                    isGoingLeft = isGoingLeft,
                    isGoingRight = isGoingRight,
                    offset = offset,
                    maxHeigth = maxHeigth,
                    maxWidth = maxWidth,
                    radius = radius
                )

            }) {
                Text(text = "Left")
            }
            Button(onClick = {
                isGoingUp = false
                isGoingDown = false
                isGoingLeft = false
                isGoingRight = true
                offset = snakeMovement(
                    isGoingUp = isGoingUp,
                    isGoingDown = isGoingDown,
                    isGoingLeft = isGoingLeft,
                    isGoingRight = isGoingRight,
                    offset = offset,
                    maxHeigth = maxHeigth,
                    maxWidth = maxWidth,
                    radius = radius
                )

            }) {
                Text(text = "Right")
            }
            Text(
                text = "Points: $points",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        BoxWithConstraints(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {


            maxHeigth = constraints.maxHeight.toFloat()
            maxWidth = constraints.maxWidth.toFloat()


            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {


                LaunchedEffect(key1 = offset, key2 = isGoingDown) {
                    delay(delayTime)
                    offset = snakeMovement(
                        isGoingUp = isGoingUp,
                        isGoingDown = isGoingDown,
                        isGoingLeft = isGoingLeft,
                        isGoingRight = isGoingRight,
                        offset = offset,
                        maxHeigth = maxHeigth,
                        maxWidth = maxWidth,
                        radius = radius
                    )
                }

                LaunchedEffect(key1 = offset, key2 = isGoingDown) {
                    delay(delayTime)
                    offset = snakeMovement(
                        isGoingUp = isGoingUp,
                        isGoingDown = isGoingDown,
                        isGoingLeft = isGoingLeft,
                        isGoingRight = isGoingRight,
                        offset = offset,
                        maxHeigth = maxHeigth,
                        maxWidth = maxWidth,
                        radius = radius
                    )
                }

                LaunchedEffect(key1 = offset, key2 = isGoingDown) {
                    delay(delayTime)
                    offset = snakeMovement(
                        isGoingUp = isGoingUp,
                        isGoingDown = isGoingDown,
                        isGoingLeft = isGoingLeft,
                        isGoingRight = isGoingRight,
                        offset = offset,
                        maxHeigth = maxHeigth,
                        maxWidth = maxWidth,
                        radius = radius
                    )
                }
                LaunchedEffect(key1 = offset, key2 = isGoingRight) {
                    delay(delayTime)
                    offset = snakeMovement(
                        isGoingUp = isGoingUp,
                        isGoingDown = isGoingDown,
                        isGoingLeft = isGoingLeft,
                        isGoingRight = isGoingRight,
                        offset = offset,
                        maxHeigth = maxHeigth,
                        maxWidth = maxWidth,
                        radius = radius
                    )
                }

                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent)
                ) {
                    drawCircle(
                        color = ballColor,
                        radius = radius,
                        center = newOffset

                    )

                    drawCircle(
                        color = Color.Green,
                        radius = radius,
                        center = ballPosition
                    )
                }


                //when the newOffset is between the ballPosition and the radius of the ball
                //the ballPosition is updated to a new random position
                if (newOffset.x in ballPosition.x - radius..ballPosition.x + radius && newOffset.y in ballPosition.y - radius..ballPosition.y + radius) {
                    ballPosition = randomOffset(
                        radius = radius,
                        width = maxWidth.toInt(),
                        height = maxHeigth.toInt()
                    )
                    onBallTrigger()
                }
            }


        }
    }


}

private fun snakeMovement(
    isGoingUp: Boolean,
    isGoingDown: Boolean,
    isGoingRight: Boolean,
    isGoingLeft: Boolean,
    offset: Offset,
    maxHeigth: Float,
    maxWidth: Float,
    radius: Float
): Offset {


    return when {
        isGoingUp -> {
            return if (offset.y <= radius) {
                Offset(
                    x = offset.x,
                    y = offset.y
                )
            } else {
                Offset(
                    x = offset.x,
                    y = offset.y - radius / 2
                )
            }
        }

        isGoingDown -> {
            return if (offset.y >= maxHeigth - radius) {
                Offset(
                    x = offset.x,
                    y = offset.y
                )
            } else {
                Offset(
                    x = offset.x,
                    y = offset.y + radius / 2
                )
            }
        }

        isGoingRight -> {
            return if (offset.x >= maxWidth - radius) {
                Offset(
                    x = offset.x,
                    y = offset.y
                )
            } else {
                Offset(
                    x = offset.x + radius / 2,
                    y = offset.y
                )
            }
        }

        isGoingLeft -> {
            return if (offset.x <= radius) {
                Offset(
                    x = offset.x,
                    y = offset.y
                )
            } else {
                Offset(
                    x = offset.x - radius / 2,
                    y = offset.y
                )
            }
        }

        else -> {
            return offset
        }
    }
}


private fun randomOffset(radius: Float, width: Int, height: Int): Offset {
    return Offset(
        x = Random.nextInt(radius.roundToInt(), width - radius.roundToInt()).toFloat(),
        y = Random.nextInt(radius.roundToInt(), height - radius.roundToInt()).toFloat()
    )
}

