package br.com.vtvinicius.uikit.ui.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.ui.text.BodyMediumText


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    modifierRow: Modifier = Modifier,
    text: String,
    textColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit,
) {

    Card(
        elevation = 8.dp,
        backgroundColor = backgroundColor,
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
    ) {

        Row(
            modifierRow.padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BodyMediumText(text = text, colors = textColor, fontWeight = FontWeight.Bold)
        }
    }

}