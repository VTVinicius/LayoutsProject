package br.com.vtvinicius.feature_canvas.star

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R

@Composable
fun Star5(
    onStarSelected: (Stars) -> Unit,
    pathScaleFactor: Float = 7f,
    distanceBetweenStars: Dp = 35.dp,
    animStarTime: Int = 300,
    colorStarSelected: Color = Color(0XFFffd700),
    colorStarUnselected: Color = Color.LightGray,
) {

    val star1PathString = stringResource(id = R.string.star_small_path)
    val star2PathString = stringResource(id = R.string.star_small_path)
    val star3PathString = stringResource(id = R.string.star_small_path)
    val star4PathString = stringResource(id = R.string.star_small_path)
    val star5PathString = stringResource(id = R.string.star_small_path)

    var center by remember {
        mutableStateOf(Offset.Unspecified)
    }

    val star1Path = remember {
        PathParser().parsePathString(star1PathString).toPath()
    }
    val star2Path = remember {
        PathParser().parsePathString(star2PathString).toPath()
    }
    val star3Path = remember {
        PathParser().parsePathString(star3PathString).toPath()
    }
    val star4Path = remember {
        PathParser().parsePathString(star4PathString).toPath()
    }
    val star5Path = remember {
        PathParser().parsePathString(star5PathString).toPath()
    }

    val star1PathBounds = remember {
        star1Path.getBounds()
    }
    val star2PathBounds = remember {
        star2Path.getBounds()
    }
    val star3PathBounds = remember {
        star3Path.getBounds()
    }
    val star4PathBounds = remember {
        star4Path.getBounds()
    }
    val star5PathBounds = remember {
        star5Path.getBounds()
    }

    var currentClickOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    var selectedStar by remember {
        mutableStateOf<Stars>(Stars.Star0)
    }

    var star1TranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }
    var star2TranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }
    var star3TranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }
    var star4TranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }
    var star5TranslationOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    var targetValue1 by remember {
        mutableStateOf(0f)
    }
    var targetValue2 by remember {
        mutableStateOf(0f)
    }
    var targetValue3 by remember {
        mutableStateOf(0f)
    }
    var targetValue4 by remember {
        mutableStateOf(0f)
    }
    var targetValue5 by remember {
        mutableStateOf(0f)
    }

    targetValue1 =
        if (selectedStar is Stars.Star1 || selectedStar is Stars.Star2 || selectedStar is Stars.Star3 || selectedStar is Stars.Star4 || selectedStar is Stars.Star5) 80f else 0f
    targetValue2 =
        if (selectedStar is Stars.Star2 || selectedStar is Stars.Star3 || selectedStar is Stars.Star4 || selectedStar is Stars.Star5) 80f else 0f
    targetValue3 =
        if (selectedStar is Stars.Star5 || selectedStar is Stars.Star4 || selectedStar is Stars.Star3) 80f else 0f
    targetValue4 = if (selectedStar is Stars.Star4 || selectedStar is Stars.Star5) 80f else 0f
    targetValue5 = if (selectedStar is Stars.Star5) 80f else 0f

    val star1SelectionRadius = animateFloatAsState(
        targetValue = targetValue1,
        animationSpec = if (targetValue5 == 80f) tween(durationMillis = animStarTime * 1) else tween(
            durationMillis = animStarTime / 2 * 5
        )
    )
    val star2SelectionRadius = animateFloatAsState(
        targetValue = targetValue2,
        animationSpec = if (targetValue5 == 80f) tween(durationMillis = animStarTime * 2) else tween(
            durationMillis = animStarTime / 2 * 4
        )
    )
    val star3SelectionRadius = animateFloatAsState(
        targetValue = targetValue3,
        animationSpec = if (targetValue5 == 80f) tween(durationMillis = animStarTime * 3) else tween(
            durationMillis = animStarTime / 2 * 3
        )
    )
    val star4SelectionRadius = animateFloatAsState(
        targetValue = targetValue4,
        animationSpec = if (targetValue5 == 80f) tween(durationMillis = animStarTime * 4) else tween(
            durationMillis = animStarTime / 2 * 2
        )
    )
    val star5SelectionRadius = animateFloatAsState(
        targetValue = targetValue5,
        animationSpec = if (targetValue5 == 80f) tween(durationMillis = animStarTime * 5) else tween(
            durationMillis = animStarTime / 2 * 1
        )
    )

    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {

        Canvas(modifier = Modifier
            .fillMaxWidth()
            .pointerInput(true) {
                detectTapGestures {
                    val transformedStar1Rect = Rect(
                        offset = star1TranslationOffset,
                        size = star1PathBounds.size * pathScaleFactor
                    )
                    val transformedStar2Rect = Rect(
                        offset = star2TranslationOffset,
                        size = star2PathBounds.size * pathScaleFactor
                    )
                    val transformedStar3Rect = Rect(
                        offset = star3TranslationOffset,
                        size = star3PathBounds.size * pathScaleFactor
                    )
                    val transformedStar4Rect = Rect(
                        offset = star4TranslationOffset,
                        size = star4PathBounds.size * pathScaleFactor
                    )
                    val transformedStar5Rect = Rect(
                        offset = star5TranslationOffset,
                        size = star5PathBounds.size * pathScaleFactor
                    )


                    if (transformedStar1Rect.contains(it)) {
                        selectedStar = Stars.Star1
                        onStarSelected(selectedStar)
                    } else if (transformedStar2Rect.contains(it)) {
                        selectedStar = Stars.Star2
                        onStarSelected(selectedStar)
                    } else if (transformedStar3Rect.contains(it)) {
                        selectedStar = Stars.Star3
                        onStarSelected(selectedStar)
                    } else if (transformedStar4Rect.contains(it)) {
                        selectedStar = Stars.Star4
                        onStarSelected(selectedStar)
                    } else if (transformedStar5Rect.contains(it)) {
                        selectedStar = Stars.Star5
                        onStarSelected(selectedStar)
                    }
                }
            }) {

            center = this.center


            star1TranslationOffset = Offset(
                x = star1PathBounds.width * pathScaleFactor / 2f,
                y = center.y - star1PathBounds.height * pathScaleFactor / 2f
            )

            star2TranslationOffset = Offset(
                x = star1TranslationOffset.x + star1PathBounds.width + distanceBetweenStars.toPx(),
                y = center.y - star1PathBounds.height * pathScaleFactor / 2f
            )

            star3TranslationOffset = Offset(
                x = star2TranslationOffset.x + star1PathBounds.width + distanceBetweenStars.toPx(),
                y = center.y - star1PathBounds.height * pathScaleFactor / 2f
            )

            star4TranslationOffset = Offset(
                x = star3TranslationOffset.x + star1PathBounds.width + distanceBetweenStars.toPx(),
                y = center.y - star1PathBounds.height * pathScaleFactor / 2f
            )

            star5TranslationOffset = Offset(
                x = star4TranslationOffset.x + star1PathBounds.width + distanceBetweenStars.toPx(),
                y = center.y - star1PathBounds.height * pathScaleFactor / 2f
            )

            val untransformedStar1ClickOffset = if (currentClickOffset == Offset.Zero) {
                star1PathBounds.center
            } else {
                (currentClickOffset - star1TranslationOffset) / pathScaleFactor
            }

            val untransformedStar2ClickOffset = if (currentClickOffset == Offset.Zero) {
                star2PathBounds.center
            } else {
                (currentClickOffset - star2TranslationOffset) / pathScaleFactor
            }

            val untransformedStar3ClickOffset = if (currentClickOffset == Offset.Zero) {
                star3PathBounds.center
            } else {
                (currentClickOffset - star3TranslationOffset) / pathScaleFactor
            }

            val untransformedStar4ClickOffset = if (currentClickOffset == Offset.Zero) {
                star4PathBounds.center
            } else {
                (currentClickOffset - star4TranslationOffset) / pathScaleFactor
            }

            val untransformedStar5ClickOffset = if (currentClickOffset == Offset.Zero) {
                star5PathBounds.center
            } else {
                (currentClickOffset - star5TranslationOffset) / pathScaleFactor
            }

            translate(
                left = star1TranslationOffset.x,
                top = star1TranslationOffset.y
            ) {
                scale(
                    scale = pathScaleFactor,
                    pivot = star1PathBounds.topLeft
                ) {
                    drawPath(
                        path = star1Path,
                        color = colorStarUnselected,
                    )
                    clipPath(
                        path = star1Path
                    ) {
                        drawCircle(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    colorStarSelected,
                                    colorStarSelected
                                ),
                                center = untransformedStar1ClickOffset,
                                radius = star1SelectionRadius.value + 0.1f
                            ),
                            radius = star1SelectionRadius.value / 4,
                            center = untransformedStar1ClickOffset
                        )
                    }
                }
            }

            translate(
                left = star2TranslationOffset.x,
                top = star2TranslationOffset.y
            ) {
                scale(
                    scale = pathScaleFactor,
                    pivot = star2PathBounds.topLeft
                ) {
                    drawPath(
                        path = star2Path,
                        color = colorStarUnselected,
                    )
                    clipPath(
                        path = star2Path
                    ) {
                        drawCircle(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    colorStarSelected,
                                    colorStarSelected
                                ),
                                center = untransformedStar2ClickOffset,
                                radius = star2SelectionRadius.value + 0.1f
                            ),
                            radius = star2SelectionRadius.value,
                            center = untransformedStar2ClickOffset
                        )
                    }
                }


            }

            translate(
                left = star3TranslationOffset.x,
                top = star3TranslationOffset.y
            ) {
                scale(
                    scale = pathScaleFactor,
                    pivot = star3PathBounds.topLeft
                ) {
                    drawPath(
                        path = star3Path,
                        color = colorStarUnselected,
                    )
                    clipPath(
                        path = star3Path
                    ) {
                        drawCircle(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    colorStarSelected,
                                    colorStarSelected
                                ),
                                center = untransformedStar3ClickOffset,
                                radius = star3SelectionRadius.value + 0.1f
                            ),
                            radius = star3SelectionRadius.value,
                            center = untransformedStar3ClickOffset
                        )
                    }
                }


            }

            translate(
                left = star4TranslationOffset.x,
                top = star4TranslationOffset.y
            ) {
                scale(
                    scale = pathScaleFactor,
                    pivot = star4PathBounds.topLeft
                ) {
                    drawPath(
                        path = star4Path,
                        color = colorStarUnselected
                    )
                    clipPath(
                        path = star4Path
                    ) {
                        drawCircle(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    colorStarSelected,
                                    colorStarSelected
                                ),
                                center = untransformedStar4ClickOffset,
                                radius = star4SelectionRadius.value + 0.1f
                            ),
                            radius = star4SelectionRadius.value,
                            center = untransformedStar4ClickOffset
                        )
                    }
                }


            }

            translate(
                left = star5TranslationOffset.x,
                top = star5TranslationOffset.y
            ) {
                scale(
                    scale = pathScaleFactor,
                    pivot = star5PathBounds.topLeft
                ) {
                    drawPath(
                        path = star5Path,
                        color = colorStarUnselected
                    )
                    clipPath(
                        path = star5Path
                    ) {
                        drawCircle(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    colorStarSelected,
                                    colorStarSelected
                                ),
                                center = untransformedStar5ClickOffset,
                                radius = star5SelectionRadius.value + 0.1f
                            ),
                            radius = star5SelectionRadius.value,
                            center = untransformedStar5ClickOffset
                        )
                    }
                }
            }
        }
    }
}