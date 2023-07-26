package br.com.vtvinicius.feature_canvas.batman_card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar

@Composable
fun BatmanCardScreen() {


    AppScaffold(topBar = { AppTopBar(title = "Batman Card") }, content = {

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BatmanCard()
        }

    })
}

@Preview
@Composable
fun BatmanCardScreenPreview() {
    BatmanCardScreen()
}