package br.com.vtvinicius.feature_canvas.star

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.feature_canvas.gender_picker.Gender
import br.com.vtvinicius.uikit.R

@androidx.compose.runtime.Composable
fun StarComponent(
    size: Int = 50,
    color: Color = Color.Yellow,
    numberOfPoints: Int = 5,
    modifier: Modifier = Modifier,
    note: Int = 5,
    pathScaleFactor: Float = 7f,
) {
    val infiniteTransition = rememberInfiniteTransition()
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 10000f,
        animationSpec = infiniteRepeatable(
            animation = tween(60000, easing = LinearEasing)
        )
    )
    Canvas(modifier = modifier, onDraw = {
        val star = PathParser()
            .parsePathString("M570.5,252.5l93.8,190c1.5,3.1 4.5,5.3 8,5.8l209.7,30.5c8.7,1.3 12.2,11.9 5.9,18.1L736.1,644.8c-2.5,2.4 -3.6,5.9 -3,9.4L768.8,863c1.5,8.7 -7.6,15.2 -15.4,11.2l-187.5,-98.6c-3.1,-1.6 -6.8,-1.6 -9.9,0l-187.5,98.6c-7.8,4.1 -16.9,-2.5 -15.4,-11.2L389,654.1c0.6,-3.4 -0.5,-6.9 -3,-9.4L234.2,496.9c-6.3,-6.1 -2.8,-16.8 5.9,-18.1l209.7,-30.5c3.4,-0.5 6.4,-2.7 8,-5.8l93.8,-190C555.4,244.7 566.6,244.7 570.5,252.5z")
            .toPath()


        //drow a path of the star, with the color and the size
        scale(0.5f) {

            drawPath(
                path = star,
                color = color,
                style = Stroke(
                    width = 2.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(
                        intervals = floatArrayOf(0f, 0f),
                        phase = phase,
                    )
                )
            )
        }
    }
    )

}

@Composable
fun Star2(
    modifier: Modifier = Modifier,
    starColor: Color = Color.Yellow,
    distanceBetweenStars: Dp = 50.dp,
    pathScaleFactor: Float = 0.3f,
) {
    var selectedGender by remember {
        mutableStateOf<Gender>(Gender.Female)
    }
    var center by remember {
        mutableStateOf(Offset.Unspecified)
    }

    val starPathString =
        "M570.5,252.5l93.8,190c1.5,3.1 4.5,5.3 8,5.8l209.7,30.5c8.7,1.3 12.2,11.9 5.9,18.1L736.1,644.8c-2.5,2.4 -3.6,5.9 -3,9.4L768.8,863c1.5,8.7 -7.6,15.2 -15.4,11.2l-187.5,-98.6c-3.1,-1.6 -6.8,-1.6 -9.9,0l-187.5,98.6c-7.8,4.1 -16.9,-2.5 -15.4,-11.2L389,654.1c0.6,-3.4 -0.5,-6.9 -3,-9.4L234.2,496.9c-6.3,-6.1 -2.8,-16.8 5.9,-18.1l209.7,-30.5c3.4,-0.5 6.4,-2.7 8,-5.8l93.8,-190C555.4,244.7 566.6,244.7 570.5,252.5z"


    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }

    val starPathBounds = remember {
        starPath.getBounds()
    }

    var starTranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    val starSelectionRadius = animateFloatAsState(
        targetValue = 80f,
        animationSpec = tween(durationMillis = 5000)
    )

    var currentClickOffset by remember {
        mutableStateOf(Offset.Zero)
    }



    Canvas(
        modifier = modifier
            .pointerInput(true) {
                detectTapGestures {
                    val transformedMaleRect = Rect(
                        offset = starTranslationOffset,
                        size = starPathBounds.size * pathScaleFactor
                    )
                    if (transformedMaleRect.contains(it)) {
                        currentClickOffset = it
                        selectedGender = Gender.Male
                    }
                }
            }
    ) {

        center = this.center

        starTranslationOffset = Offset(
            x = center.x - starPathBounds.width * pathScaleFactor - distanceBetweenStars.toPx() / 2f,
            y = center.y - pathScaleFactor * starPathBounds.height / 2f
        )
        val untransformedStarClickOffset = if (currentClickOffset == Offset.Zero) {
            starPathBounds.center
        } else {
            (currentClickOffset - starTranslationOffset) / pathScaleFactor
        }

        translate(
            left = starTranslationOffset.x,
            top = starTranslationOffset.y
        ) {
            scale(
                scale = pathScaleFactor,
                pivot = starPathBounds.topLeft
            ) {
                drawPath(
                    path = starPath,
                    color = Color.LightGray
                )
                clipPath(
                    path = starPath
                ) {
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                starColor,
                                starColor
                            ),
                            center = untransformedStarClickOffset,
                            radius = starSelectionRadius.value + 1f
                        ),
                        radius = starSelectionRadius.value,
                        center = untransformedStarClickOffset
                    )
                }
            }

        }

    }
}


@Composable
fun Star3(
    modifier: Modifier = Modifier,
    maleGradient: List<Color> = listOf(Color.Yellow, Color.Yellow),
    femaleGradient: List<Color> = listOf(Color.Yellow, Color.Yellow),
    distanceBetweenGenders: Dp = 20.dp,
    size: Int = 10,
    onGenderSelected: (Gender) -> Unit,
) {
    var selectedGender by remember {
        mutableStateOf<Gender>(Gender.Male)
    }
    var center by remember {
        mutableStateOf(Offset.Unspecified)
    }

    val malePathString = stringResource(id = R.string.star_path)
    val femalePathString = stringResource(id = R.string.star_path)

    val malePath = remember {
        PathParser().parsePathString(malePathString).toPath()
    }
    val femalePath = remember {
        PathParser().parsePathString(femalePathString).toPath()
    }

    val malePathBounds = remember {
        malePath.getBounds()
    }
    val femalePathBounds = remember {
        femalePath.getBounds()
    }

    var maleTranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }
    var femaleTranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    var currentClickOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    val maleSelectionRadius = animateFloatAsState(
        targetValue = if (selectedGender is Gender.Male) 2000f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )
    val femaleSelectionRadius = animateFloatAsState(
        targetValue = if (selectedGender is Gender.Female) 2000f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )


    Canvas(
        modifier = modifier
            .pointerInput(true) {
                detectTapGestures {
                    val transformedMaleRect = Rect(
                        offset = maleTranslationOffset,
                        size = malePathBounds.size
                    )
                    val transformedFemaleRect = Rect(
                        offset = femaleTranslationOffset,
                        size = femalePathBounds.size
                    )
                    if (selectedGender !is Gender.Male && transformedMaleRect.contains(it)) {
                        currentClickOffset = it
                        selectedGender = Gender.Male
                        onGenderSelected(Gender.Male)
                    } else if (selectedGender !is Gender.Female && transformedFemaleRect.contains(it)) {
                        currentClickOffset = it
                        selectedGender = Gender.Female
                        onGenderSelected(Gender.Female)
                    }
                }
            }
    ) {
        center = this.center

        maleTranslationOffset = Offset(
            x = center.x - size.toDp().toPx(),
            y = center.y - size.toDp().toPx()
        )
        femaleTranslationOffset = Offset(
            x = center.x - size.toDp().toPx() + distanceBetweenGenders.toPx() / 2f,
            y = center.y - size.toDp().toPx() / 2f
        )

        val untransformedMaleClickOffset =
            (currentClickOffset - maleTranslationOffset) / size.toDp().toPx()
        val untransformedFemaleClickOffset =
            (currentClickOffset - femaleTranslationOffset) / size.toDp().toPx()


        translate(
            left = maleTranslationOffset.x,
            top = maleTranslationOffset.y
        ) {
            scale(
                scale = size.toDp().toPx(),
                pivot = malePathBounds.topLeft
            ) {
                drawPath(
                    path = malePath,
                    color = Color.LightGray
                )
                clipPath(
                    path = malePath
                ) {
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = maleGradient,
                            center = untransformedMaleClickOffset,
                            radius = maleSelectionRadius.value + 1f
                        ),
                        radius = maleSelectionRadius.value,
                        center = untransformedMaleClickOffset
                    )
                }
            }

        }
        translate(
            left = femaleTranslationOffset.x,
            top = femaleTranslationOffset.y
        ) {
            scale(
                scale = size.toDp().toPx(),
                pivot = femalePathBounds.topLeft
            ) {
                drawPath(
                    path = femalePath,
                    color = Color.LightGray
                )
                clipPath(
                    path = femalePath
                ) {
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = femaleGradient,
                            center = untransformedFemaleClickOffset,
                            radius = femaleSelectionRadius.value + 1
                        ),
                        radius = femaleSelectionRadius.value,
                        center = untransformedFemaleClickOffset
                    )
                }
            }
        }


    }
}

@Composable
fun Star7(
    modifier: Modifier = Modifier,
    maleGradient: List<Color> = listOf(Color.Yellow, Color.Yellow),
    femaleGradient: List<Color> = listOf(Color.Yellow, Color.Yellow),
    distanceBetweenGenders: Dp = 50.dp,
    pathScaleFactor: Float = 10f,
    onGenderSelected: (Gender) -> Unit,
) {
    var selectedGender by remember {
        mutableStateOf<Gender>(Gender.Female)
    }
    var center by remember {
        mutableStateOf(Offset.Unspecified)
    }

    val malePathString = stringResource(id = R.string.star_small_path)
    val femalePathString = stringResource(id = R.string.star_small_path)

    val malePath = remember {
        PathParser().parsePathString(malePathString).toPath()
    }
    val femalePath = remember {
        PathParser().parsePathString(femalePathString).toPath()
    }

    val malePathBounds = remember {
        malePath.getBounds()
    }
    val femalePathBounds = remember {
        femalePath.getBounds()
    }

    var maleTranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }
    var femaleTranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    var currentClickOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    val maleSelectionRadius = animateFloatAsState(
        targetValue = if (selectedGender is Gender.Male) 2000f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )
    val femaleSelectionRadius = animateFloatAsState(
        targetValue = if (selectedGender is Gender.Female) 2000f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )


    Canvas(
        modifier = modifier
            .pointerInput(true) {
                detectTapGestures {
                    val transformedMaleRect = Rect(
                        offset = maleTranslationOffset,
                        size = malePathBounds.size
                    )
                    val transformedFemaleRect = Rect(
                        offset = femaleTranslationOffset,
                        size = femalePathBounds.size
                    )
                    if (selectedGender !is Gender.Male && transformedMaleRect.contains(it)) {
                        currentClickOffset = it
                        selectedGender = Gender.Male
                        onGenderSelected(Gender.Male)
                    } else if (selectedGender !is Gender.Female && transformedFemaleRect.contains(it)) {
                        currentClickOffset = it
                        selectedGender = Gender.Female
                        onGenderSelected(Gender.Female)
                    }
                }
            }
    ) {
        center = this.center

        maleTranslationOffset = Offset(
            x = center.x - malePathBounds.width * distanceBetweenGenders.toPx() / 2f,
            y = center.y - pathScaleFactor * malePathBounds.height / 2f
        )
        femaleTranslationOffset = Offset(
            x = center.x + distanceBetweenGenders.toPx() / 2f,
            y = center.y - femalePathBounds.height / 2f
        )

        val untransformedMaleClickOffset = (currentClickOffset - maleTranslationOffset) / pathScaleFactor
        val untransformedFemaleClickOffset = (currentClickOffset - femaleTranslationOffset) / pathScaleFactor


        translate(
            left = maleTranslationOffset.x,
            top = maleTranslationOffset.y
        ) {
            scale(
                scale = malePathBounds.width,
                pivot = malePathBounds.topLeft
            ) {
                drawPath(
                    path = malePath,
                    color = Color.LightGray
                )
                clipPath(
                    path = malePath
                ) {
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = maleGradient,
                            center = untransformedMaleClickOffset,
                            radius = maleSelectionRadius.value + 1f
                        ),
                        radius = maleSelectionRadius.value,
                        center = untransformedMaleClickOffset
                    )
                }
            }

        }
        translate(
            left = femaleTranslationOffset.x,
            top = femaleTranslationOffset.y
        ) {
            scale(
                scale = pathScaleFactor,
                pivot = femalePathBounds.topLeft
            ) {
                drawPath(
                    path = femalePath,
                    color = Color.LightGray
                )
                clipPath(
                    path = femalePath
                ) {
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = femaleGradient,
                            center = untransformedFemaleClickOffset,
                            radius = femaleSelectionRadius.value + 1
                        ),
                        radius = femaleSelectionRadius.value,
                        center = untransformedFemaleClickOffset
                    )
                }
            }
        }


    }
}

@Composable
fun Star4(numStars: Int) {

    val pathString = stringResource(id = R.string.star_path)

    val path = PathParser().parsePathString(pathString).toPath()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color.Transparent)
    ) {
        repeat(5) { index ->
            Canvas(modifier = Modifier) {
                if (index < numStars) {
                    drawPath(path = path, color = Color.Yellow)
                }
            }
        }
    }
}


@Composable
fun Star12(
    modifier: Modifier = Modifier,
    maleGradient: List<Color> = listOf(Color(0xFF6D6DFF), Color.Blue),
    femaleGradient: List<Color> = listOf(Color(0xFFEA76FF), Color.Magenta),
    distanceBetweenGenders: Dp = 50.dp,
    pathScaleFactor: Float = 7f,
    onGenderSelected: (Gender) -> Unit,
    size: Int = 20
) {
    var selectedGender by remember {
        mutableStateOf<Gender>(Gender.Female)
    }
    var center by remember {
        mutableStateOf(Offset.Unspecified)
    }

    val malePathString = stringResource(id = R.string.star_small_path)
    val femalePathString = stringResource(id = R.string.star_small_path)

    val malePath = remember {
        PathParser().parsePathString(malePathString).toPath()
    }
    val femalePath = remember {
        PathParser().parsePathString(femalePathString).toPath()
    }

    val malePathBounds = remember {
        malePath.getBounds()
    }
    val femalePathBounds = remember {
        femalePath.getBounds()
    }

    var maleTranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }
    var femaleTranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    var currentClickOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    val maleSelectionRadius = animateFloatAsState(
        targetValue = if (selectedGender is Gender.Male) 1000f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )
    val femaleSelectionRadius = animateFloatAsState(
        targetValue = if (selectedGender is Gender.Female) 1000f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )


    Canvas(
        modifier = modifier
            .pointerInput(true) {
                detectTapGestures {
                    val transformedMaleRect = Rect(
                        offset = maleTranslationOffset,
                        size = malePathBounds.size
                    )
                    val transformedFemaleRect = Rect(
                        offset = femaleTranslationOffset,
                        size = femalePathBounds.size
                    )
                    if (selectedGender !is Gender.Male && transformedMaleRect.contains(it)) {
                        currentClickOffset = it
                        selectedGender = Gender.Male
                        onGenderSelected(Gender.Male)
                    } else if (selectedGender !is Gender.Female && transformedFemaleRect.contains(it)) {
                        currentClickOffset = it
                        selectedGender = Gender.Female
                        onGenderSelected(Gender.Female)
                    }
                }
            }
    ) {
        center = this.center

        maleTranslationOffset = Offset(
            x = center.x - malePathBounds.width * pathScaleFactor - distanceBetweenGenders.toPx() / 2f,
            y = center.y - pathScaleFactor * malePathBounds.height / 2f
        )
        femaleTranslationOffset = Offset(
            x = center.x + distanceBetweenGenders.toPx() / 2f,
            y = center.y - pathScaleFactor * femalePathBounds.height / 2f
        )

        val untransformedMaleClickOffset = (currentClickOffset - maleTranslationOffset) / pathScaleFactor
        val untransformedFemaleClickOffset = (currentClickOffset - femaleTranslationOffset) / pathScaleFactor


        translate(
            left = maleTranslationOffset.x,
            top = maleTranslationOffset.y
        ) {
            scale(
                scale = pathScaleFactor,
                pivot = malePathBounds.topLeft
            ) {
                drawPath(
                    path = malePath,
                    color = Color.LightGray
                )
                clipPath(
                    path = malePath
                ) {
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = maleGradient,
                            center = untransformedMaleClickOffset,
                            radius = maleSelectionRadius.value + 1f
                        ),
                        radius = maleSelectionRadius.value,
                        center = untransformedMaleClickOffset
                    )
                }
            }

        }
        translate(
            left = femaleTranslationOffset.x,
            top = femaleTranslationOffset.y
        ) {
            scale(
                scale = pathScaleFactor,
                pivot = femalePathBounds.topLeft
            ) {
                drawPath(
                    path = femalePath,
                    color = Color.LightGray
                )
                clipPath(
                    path = femalePath
                ) {
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = femaleGradient,
                            center = untransformedFemaleClickOffset,
                            radius = femaleSelectionRadius.value + 1
                        ),
                        radius = femaleSelectionRadius.value,
                        center = untransformedFemaleClickOffset
                    )
                }
            }
        }


    }
}