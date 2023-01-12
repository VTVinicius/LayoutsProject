package br.com.vtvinicius.feature_clones.linkedin.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.blueLinkedin
import br.com.vtvinicius.uikit.ui.button.CircularIconButton
import br.com.vtvinicius.uikit.ui.button.RoundedButtons
import br.com.vtvinicius.uikit.ui.text.BodyLargeText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun TopButtonsRow() {
    Column(
        Modifier
            .fillMaxSize()
    ) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_plus),
                contentDescription = "Plus",
                tint = blueLinkedin,
                modifier = Modifier.size(10.dp)
            )
            HorizontalSpacer(width = 4)
            BodyLargeText(
                text = "de 500 conexões",
                colors = blueLinkedin,
                fontWeight = FontWeight.Normal
            )


        }


        VerticalSpacer(height = 8)

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {


            RoundedButtons(
                onClick = { /*TODO*/ }, modifier = Modifier.weight(5f),
                buttonColor = blueLinkedin,
                text = "Tenho \n interesse em...",
                textColor = Color.White
            )
            HorizontalSpacer(width = 4)
            RoundedButtons(
                onClick = { /*TODO*/ },
                buttonColor = Color.White,
                textColor = Color.Gray,
                modifier = Modifier.weight(5f),
                text = "Adicionar \n seção"
            )
            HorizontalSpacer(width = 4)
            CircularIconButton(
                onClick = { /*TODO*/ },
                buttonColor = Color.White,
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_three_dots,
            )
        }
        VerticalSpacer(height = 8)
    }
}
