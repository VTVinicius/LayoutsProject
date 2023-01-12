package br.com.vtvinicius.feature_clones.linkedin.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.ui.text.BodyLargeText
import br.com.vtvinicius.uikit.ui.text.BodyMediumText
import br.com.vtvinicius.uikit.ui.text.TitleLargeText
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun AboutSection() {


    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)) {

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

            TitleLargeText(text = "Sobre", fontWeight = FontWeight.Bold)

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Icon(
                    painter = painterResource(id = br.com.vtvinicius.uikit.R.drawable.ic_pencil),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .padding(4.dp)
                )
            }
        }

        VerticalSpacer(height = 8)

        BodyMediumText(
            text = "Desenvolvedor Android nativo, Técnico em Informática, formado pelo Instituto Federal Catarinense.\nGithub: https://guithub.com/VTVinicius",
            align = TextAlign.Start
        )
    }
}