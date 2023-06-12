package br.com.vtvinicius.uikit.ui.neumorphism

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.backgroundComponents
import br.com.vtvinicius.uikit.ui.text.LabelLargeText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun NeumorphicCard1(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(12.dp),
    onPressed: () -> Unit = {},
    onReleased: () -> Unit = {},
    zipCode: String? = "88360-000",
    uf: String? = "SC",
    city: String? = "Brusque",
    neighborhood: String? = "Centro I",
    address: String? = "Rua Nicolau Schaefer",
) {


    val targetSize = remember { mutableStateOf(20.dp) }
    val animatedHeight by animateDpAsState(
        targetValue = targetSize.value,
        animationSpec = TweenSpec(durationMillis = 10)
    )

    val fontSizeTarget = remember { mutableStateOf(14) }
    val animatedFont by animateIntAsState(
        targetValue = fontSizeTarget.value,
        animationSpec = TweenSpec(durationMillis = 10)
    )

    val targetColor = remember { mutableStateOf(backgroundComponents) }
    val animatedColor by animateColorAsState(
        targetValue = targetColor.value,
        animationSpec = TweenSpec(durationMillis = 10)
    )

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val backgroundColor = remember { mutableStateOf(Color.LightGray) }


    if (isPressed) {
        onPressed()
        backgroundColor.value = backgroundComponents
        targetColor.value = Color.LightGray
        targetSize.value = 0.dp
        fontSizeTarget.value = 12
    }

    if (isPressed) {
        onPressed()
        backgroundColor.value = Color.White

    } else {
        onReleased()
        backgroundColor.value = Color.White

    }
    Card(
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    onClick()
                    backgroundColor.value = backgroundComponents
                    targetColor.value = Color.LightGray
                    targetSize.value = 0.dp
                    fontSizeTarget.value = 12
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(130)
                        backgroundColor.value = backgroundComponents
                        targetColor.value = backgroundComponents
                        targetSize.value = 20.dp
                        fontSizeTarget.value = 14
                    }
                }
            ),
        shape = shape,
        border = BorderStroke(5.dp, color = animatedColor),
        elevation = animatedHeight,
        backgroundColor = backgroundComponents,
        content = {
            Box(
            ) {

                Row() {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .padding(horizontal = 24.dp)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = "Location icon",
                            Modifier.size(36.dp, 43.dp)
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                    ) {

                        Row(Modifier.fillMaxWidth()) {
                            LabelLargeText(text = "$zipCode")
                        }
                        Row(Modifier.fillMaxWidth()) {
                            LabelLargeText(text = "$city / $uf")
                        }
                        Row(Modifier.fillMaxWidth()) {
                            LabelLargeText(text = "$neighborhood")
                        }
                        Row(Modifier.fillMaxWidth()) {
                            LabelLargeText(text = "$address")
                        }
                    }
                }
            }
        })

}

@Preview
@Composable
fun NeumorphicCardSamplePreview() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NeumorphicCard1(onClick = {})
    }

}
