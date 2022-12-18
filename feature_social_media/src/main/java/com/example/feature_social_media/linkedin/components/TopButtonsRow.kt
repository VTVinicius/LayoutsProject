package com.example.feature_social_media.linkedin.components

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
import br.com.vtvinicius.uikit.ui.text.BodyLargeText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer

@Composable
fun ToButtonsRow() {

    Column(Modifier.fillMaxSize().padding(horizontal = 12.dp, vertical = 16.dp)) {

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {

            Icon(painter = painterResource(id = R.drawable.ic_plus), contentDescription = "Plus", tint = Color.Blue, modifier = Modifier.size(10.dp))
            HorizontalSpacer(width = 4)
            BodyLargeText(text = "de 500 conexões", colors = Color.Blue, fontWeight = FontWeight.Normal)

        }

    }

}