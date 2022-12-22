package br.com.vtvinicius.feature_clones.linkedin.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.ui.text.BodyMediumText

@Composable
fun CompanyAndLocation(
    company: String = "Performa_IT",
    scolarity: String = "Instituto Federal Catarinense, Campus Brusque",
    state: String = "Santa Catarina, ",
    country: String = "Brasil",
) {
    Column(Modifier.padding(horizontal = 12.dp)) {


        Row(Modifier.fillMaxWidth()) {
            BodyMediumText(text = "$company°$scolarity", align = TextAlign.Start)
        }
        Row(Modifier.fillMaxWidth()) {
            BodyMediumText(text = "$state°$country", colors = Color.Gray)
        }
    }
}