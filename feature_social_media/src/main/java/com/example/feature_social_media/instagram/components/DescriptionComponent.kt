package com.example.feature_social_media.instagram.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.ui.text.BodyMediumText

@Composable
fun DescriptionComponent(
    name: String = "Vinicius Teixeira",
    description: String = "Minha descrição :)",
    modifier: Modifier = Modifier
) {

    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {


        BodyMediumText(text = name)
        BodyMediumText(text = description, maxLines = 4)
    }

}