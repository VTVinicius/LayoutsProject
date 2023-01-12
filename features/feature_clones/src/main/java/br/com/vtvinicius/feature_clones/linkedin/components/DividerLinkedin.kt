package br.com.vtvinicius.feature_clones.linkedin.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.base.dividerLinkedin

@Composable
fun DividerLinkedin() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(
                8.dp
            ),
        backgroundColor = dividerLinkedin
    ) {

    }

}