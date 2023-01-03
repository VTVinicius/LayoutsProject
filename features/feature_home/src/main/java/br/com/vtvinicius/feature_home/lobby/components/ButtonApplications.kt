package br.com.vtvinicius.feature_home.lobby.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.ui.text.TitleMediumText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonApplications(
    textColor: androidx.compose.ui.graphics.Color,
    backgroundColor: androidx.compose.ui.graphics.Color,
    text: String,
    onClick: () -> Unit,
    image: Int,
    modifier: Modifier = Modifier,
) {


    Card(
        elevation = 8.dp,
        modifier = modifier
            .padding(horizontal = 24.dp)
            .height(52.dp)
            .fillMaxWidth(), backgroundColor = backgroundColor,
        onClick = onClick,
        shape = RoundedCornerShape(6.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalSpacer(width = 16)
            TitleMediumText(text = text, colors = textColor)
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Imagem botão",
                modifier = Modifier.size(50.dp)
            )
        }

    }

}