package br.com.vtvinicius.viacep.cepScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.base.inactive
import br.com.vtvinicius.uikit.ui.text.LabelLargeText
import br.com.vtvinicius.uikit.ui.text.LabelMediumText

@Composable
fun TextSpace(
    text: String?,
    title: String,
) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        LabelLargeText(text = title)
        Column(
            Modifier
                .fillMaxWidth()
                .background(shape = RoundedCornerShape(4.dp), color = inactive)
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(4.dp))

        ) {

            LabelMediumText(
                text = text ?: "",
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
            )
        }
    }
}