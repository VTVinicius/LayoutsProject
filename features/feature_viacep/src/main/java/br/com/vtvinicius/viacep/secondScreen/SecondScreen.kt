package br.com.vtvinicius.feature_example.secondScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_example.navigation.FeatureExampleNavigation
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.text.TitleMediumText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun SecondScreen(
    navController: NavController,
    navigation: FeatureExampleNavigation,
) {

    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Second Screen",
                onBackPressed = { navigation.goToHomeScreen(navController = navController) })
        },
        content = {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TitleMediumText(text = "Second Screen")

                VerticalSpacer(height = 32)

                AppButton(
                    onClick = { navigation.goBackToEntryPoint(navController = navController) },
                    text = "Go back to Lobby"
                )

                VerticalSpacer(height = 32)

                AppButton(
                    onClick = { navigation.goToHomeScreen(navController = navController) },
                    text = "Go back to Home"
                )

                VerticalSpacer(height = 32)

                AppButton(
                    onClick = { navigation.goToCepScreen(navController = navController) },
                    text = "Go To Cep Screen"
                )
            }
        }
    )
}