package br.com.vtvinicius.feature_uikit.neumorphism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.uikit.base.lightGray
import br.com.vtvinicius.uikit.ui.neumorphism.CustomNeumorphicButton
import br.com.vtvinicius.uikit.ui.neumorphism.NeumorphicCard1
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


@Composable
fun NeumorphismScreen() {

    AppScaffold(
        backgroundColor = Color(0xFFF5F5F5),
        topBar = {
            AppTopBar(
                title = "Neumorphism",
                backgroundColor = lightGray,
                textColor = Color.Black
            )
        },
        content = {


            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                for (i in 1..3) {

                    NeumorphicCard1(onClick = {},                     )
                }

                VerticalSpacer(height = 64)

                CustomNeumorphicButton(
                    onClick = {},
                    text =
                    "Neomorfismo"
                )
            }
        }
    )
}