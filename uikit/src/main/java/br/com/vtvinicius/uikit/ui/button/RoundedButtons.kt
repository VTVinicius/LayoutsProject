package br.com.vtvinicius.uikit.ui.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.ui.text.BodyLargeText

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RoundedButtons(
    modifier: Modifier = Modifier,
    buttonColor: Color = Color.White,
    text: String = "",
    fontWeight: FontWeight = FontWeight.Bold,
    textColor: Color = Color.Black,
    strokeColor: Color = Color.LightGray,
    textModifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    Card(
        onClick = { onClick },
        backgroundColor = buttonColor,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {

                BodyLargeText(
                    text = text,
                    maxLines = 2,
                    fontWeight = fontWeight,
                    colors = textColor,
                    modifier = textModifier
                )

            }
        },
        shape = RoundedCornerShape(90.dp),
        border = BorderStroke(1.dp, strokeColor),
        modifier = modifier
    )
}

