package br.com.vtvinicius.feature_uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.uikit.base.background
import br.com.vtvinicius.uikit.base.purpleUikitDark
import br.com.vtvinicius.uikit.base.purpleUikitLight
import br.com.vtvinicius.uikit.ui.button.FeaturesButton
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun LobbyUikit(
    navController: NavController,
    navigation: FeatureUikitNavigation,
) {

    Scaffold(
        topBar = {
            AppTopBar(
                title = "UiKit", onBackPressed = { navigation.goBackToHome(navController) },
                textColor = purpleUikitDark, backgroundColor = purpleUikitLight
            )
        },
        content = {

            Column(
                Modifier
                    .fillMaxSize()
                    .background(background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                VerticalSpacer(height = 24)

                FeaturesButton(
                    backgroundColor = purpleUikitLight,
                    textColor = purpleUikitDark,
                    onClick = { navigation.goToInputText(navController) },
                    text = "Input Text"
                )

                VerticalSpacer(height = 24)

            }
        })
}



