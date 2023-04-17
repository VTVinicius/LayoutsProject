package br.com.vtvinicius.feature_uikit.neumorphism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.uikit.ui.neumorphism.NeumorphicButton1
import br.com.vtvinicius.uikit.ui.neumorphism.NeumorphicCard1
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


@Composable
fun NeumorphismScreen() {

    AppScaffold(
        backgroundColor = Color(0xFFF5F5F5),
        topBar = { AppTopBar(title = "Neumorphism") },
        content = {


            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                NeumorphicCard1(onClick = {}, content = {
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Neomorfismo")
                    }
                }
                )

                VerticalSpacer(height = 64)

                NeumorphicButton1(
                    onClick = {},
                    content = { Text(text = "Neomorfismo") },
                    modifier = Modifier.padding(1.dp)
                )


            }
        }
    )
}