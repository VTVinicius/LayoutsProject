package br.com.vtvinicius.uikit.ui.button

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.base.green
import br.com.vtvinicius.uikit.ui.text.BodyMediumText
import br.com.vtvinicius.uikit.utils.extensions.BaseButton

@Composable
fun AppButton(
    onClick: () -> Unit,
    text: String,
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .BaseButton()
            .padding(bottom = 42.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = green)
    ) {
        BodyMediumText(text = text, colors = Color.White)
    }
}