package br.com.vtvinicius.uikit.ui.button


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.ui.text.HeadlineSmallText


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FeaturesButton(
    backgroundColor: Color,
    textColor: Color,
    text: String = "",
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        elevation = 8.dp,
        backgroundColor = backgroundColor,
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier.padding(horizontal = 16.dp)
    ) {

        Row(
            Modifier.fillMaxWidth().padding(vertical = 8.dp),

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeadlineSmallText(text = text, colors = textColor)
        }
    }

}

