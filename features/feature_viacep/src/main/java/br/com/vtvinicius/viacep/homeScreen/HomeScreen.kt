package br.com.vtvinicius.viacep.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.uikit.base.*
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.text.TitleMediumText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import br.com.vtvinicius.viacep.navigation.FeatureExampleNavigation

@Composable
fun HomeScreen(
    navController: NavController,
    navigation: FeatureExampleNavigation,
) {

    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Home Screen",
                onBackPressed = { navigation.goBackToEntryPoint(navController = navController) })
        },
        content = {

            Column(
                Modifier.fillMaxSize().background(background),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TitleMediumText(text = "Home Screen")

                VerticalSpacer(height = 32)

                AppButton(
                    onClick = { navigation.goToSecondScreen(navController = navController) },
                    text = "Go to Second Screen",
                    backgroundColor = greenApp,
                    textColor = greenAppDark
                )
            }
        }
    )
}