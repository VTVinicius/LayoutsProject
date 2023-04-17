package br.com.vtvinicius.uikit.ui.neumorphism

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

        shape = shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor.value,
            contentColor = Color.Black

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
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NeumorphicButton1(onClick = {}, content = { Text(text = "Neomorfismo") })
    }

}
