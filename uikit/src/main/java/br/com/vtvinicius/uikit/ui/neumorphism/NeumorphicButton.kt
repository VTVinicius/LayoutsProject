package br.com.vtvinicius.uikit.ui.neumorphism

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.vtvinicius.uikit.base.background
import br.com.vtvinicius.uikit.base.backgroundComponents
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun NeumorphicButton1(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(12.dp),
    contentPadding: PaddingValues = PaddingValues(20.dp),
    onPressed: () -> Unit = {},
    onReleased: () -> Unit = {},
    content: @Composable() () -> Unit,
) {


    val backgroundColor = remember { mutableStateOf(Color.LightGray) }
    val borderColor = remember { mutableStateOf(Color.Gray) }
    val contentColor = remember { mutableStateOf(Color.Black) }

    val backgroundModifier = Modifier
        .shadow((-2).dp, shape, false, Color.White, Color.White)

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    if (isPressed) {
        onPressed()
        backgroundColor.value = Color.White
        borderColor.value = Color.LightGray
    } else {
        onReleased()
        backgroundColor.value = Color.White
        borderColor.value = Color.White
    }

    androidx.compose.material.Button(
        modifier = modifier.then(backgroundModifier),
        onClick = onClick,
        interactionSource = interactionSource,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor.value,
            contentColor = Color.Black,
            disabledBackgroundColor = backgroundColor.value,

            ),
        border = BorderStroke(5.dp, color = borderColor.value),
        contentPadding = contentPadding,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 20.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 20.dp,
            focusedElevation = 1.dp,
        ),

        ) {
        content()
    }
}

@Preview
@Composable
fun NeumorphicButtonSamplePreview() {
    Column(
        Modifier
            .fillMaxSize()
            .background(background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NeumorphicButton1(onClick = {}, content = { Text(text = "Neomorfismo") })
        VerticalSpacer(height = 20)
        CustomNeumorphicButton(
            onClick = {},
            text = "Neomorfismo 2",
            onPressed = { },
            onReleased = { })
    }

}

@Composable
fun CustomNeumorphicButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(12.dp),
    contentPadding: PaddingValues = PaddingValues(20.dp),
    borderStroke: BorderStroke = BorderStroke(3.dp, Color.White),
    onPressed: () -> Unit = {},
    onReleased: () -> Unit = {},
    text: String = "",
    textSize: Int = 14,
    fontWeight: FontWeight = FontWeight.Bold,
) {

    val targetSize = remember { mutableStateOf(20.dp) }
    val animatedHeight by animateDpAsState(targetValue = targetSize.value)

    val fontSizeTarget = remember { mutableStateOf(14) }
    val animatedFont by animateIntAsState(targetValue = fontSizeTarget.value)

    val targetColor = remember { mutableStateOf(backgroundComponents) }
    val animatedColor by animateColorAsState(targetValue = targetColor.value)


    val interactionSource = remember { MutableInteractionSource() }

    val backgroundColor = remember { mutableStateOf(Color.LightGray) }
    val borderColor = remember { mutableStateOf(Color.White) }
    val contentColor = remember { mutableStateOf(Color.Black) }
    val elevationValue = remember { mutableStateOf(20.dp) }

    val backgroundModifier = Modifier
        .shadow((-2).dp, shape, false, Color.White, Color.White)

    val isPressed by interactionSource.collectIsPressedAsState()

    if (isPressed) {
        onPressed()
        backgroundColor.value = backgroundComponents
        targetColor.value = Color.LightGray
        targetSize.value = 0.dp
        fontSizeTarget.value = 12

    } else {
        onReleased()
        backgroundColor.value = backgroundComponents
        targetColor.value = backgroundComponents
        targetSize.value = 20.dp
        fontSizeTarget.value = 14
    }

    Surface(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .height(60.dp)
            .width(200.dp),
        shape = shape,
        border = BorderStroke(5.dp, color = animatedColor),
        elevation = animatedHeight,
        color = backgroundColor.value,
        contentColor = Color.Black
    ) {
        Row(
            Modifier.padding(contentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = contentColor.value,
                fontSize = animatedFont.sp,
                fontWeight = fontWeight
            )
        }
    }
}