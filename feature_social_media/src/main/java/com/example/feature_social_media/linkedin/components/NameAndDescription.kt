package com.example.feature_social_media.linkedin.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.ui.text.BodyLargeText
import br.com.vtvinicius.uikit.ui.text.LabelLargeText
import br.com.vtvinicius.uikit.ui.text.TitleLargeText

@Composable
fun NameAndDescription(
    name: String = "Vinicius Teixeira",
    description: String = "Desenvolvedor Android | Kotlin | Compose | XML",
) {

    Column(
        Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {

        Row(Modifier.fillMaxWidth()) {
            TitleLargeText(text = name, fontWeight = FontWeight.Bold, align = TextAlign.Start)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            BodyLargeText(text = description, align = TextAlign.Start)
        }


    }
}