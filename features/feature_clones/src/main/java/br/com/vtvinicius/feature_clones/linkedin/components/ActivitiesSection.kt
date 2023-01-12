package br.com.vtvinicius.feature_clones.linkedin.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.base.blueLinkedin
import br.com.vtvinicius.uikit.base.inputTextGrey
import br.com.vtvinicius.uikit.ui.button.RoundedButtons
import br.com.vtvinicius.uikit.ui.text.BodyLargeText
import br.com.vtvinicius.uikit.ui.text.BodyMediumText
import br.com.vtvinicius.uikit.ui.text.TitleLargeText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


@Composable
fun ActivitiesSection() {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Column() {
                VerticalSpacer(height = 8)
                TitleLargeText(text = "Atividades", fontWeight = FontWeight.Bold)
                BodyMediumText(
                    text = "605 seguidores",
                    colors = blueLinkedin,
                    fontWeight = FontWeight.Bold,
                    align = TextAlign.Start
                )
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                VerticalSpacer(height = 4)
                RoundedButtons(
                    text = "Começar publicação",
                    onClick = {},
                    textColor = blueLinkedin,
                    buttonColor = Color.White,
                    strokeColor = blueLinkedin,
                    textModifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    fontWeight = FontWeight.Normal
                )
            }

        }

        VerticalSpacer(height = 8)
        BodyLargeText(
            text = "Você não tem publicado ultimamente",
            align = TextAlign.Start,
            fontWeight = FontWeight.Bold
        )
        VerticalSpacer(height = 4)
        BodyMediumText(
            text = "As publicações recentes que voce compartilhar ou comentar serão exibidas aqui",
            align = TextAlign.Start
        )
    }

}

@Composable
fun CardShowActivities() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp), backgroundColor = inputTextGrey
    ) {}
    Column {

        VerticalSpacer(height = 8)
        Row(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,


            ) {

            BodyLargeText(
                text = "Exibir todas as atividades",
                fontWeight = FontWeight.Bold,
                colors = Color.Gray,
                align = TextAlign.Center
            )
            HorizontalSpacer(width = 4)
            Icon(
                painter = painterResource(br.com.vtvinicius.uikit.R.drawable.ic_arrow_next),
                contentDescription = null, modifier = Modifier
                    .size(15.dp)
            )

        }
        VerticalSpacer(height = 8)

    }
}