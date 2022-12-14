package br.com.vtvinicius.feature_example.homeScreen

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
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TitleMediumText(text = "Home Screen")

                VerticalSpacer(height = 32)

                AppButton(
                    onClick = { navigation.goToSecondScreen(navController = navController) },
                    text = "Go to Second Screen"
                )
            }
        }
    )
}