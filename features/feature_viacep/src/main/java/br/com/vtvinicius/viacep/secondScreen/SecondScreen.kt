package br.com.vtvinicius.viacep.secondScreen

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
import br.com.vtvinicius.uikit.base.background
import br.com.vtvinicius.uikit.base.greenApp
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.text.TitleMediumText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import br.com.vtvinicius.viacep.navigation.FeatureExampleNavigation

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
                Modifier
                    .fillMaxSize()
                    .background(background),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TitleMediumText(text = "Second Screen")

                VerticalSpacer(height = 32)

                AppButton(
                    onClick = { navigation.goBackToEntryPoint(navController = navController) },
                    text = "Go back to Lobby",
                    backgroundColor = greenApp,
                    textColor = Color.White
                )

                VerticalSpacer(height = 32)

                AppButton(
                    onClick = { navigation.goToHomeScreen(navController = navController) },
                    text = "Go back to Home",
                    backgroundColor = greenApp,
                    textColor = Color.White
                )

                VerticalSpacer(height = 32)

                AppButton(
                    onClick = { navigation.goToCepScreen(navController = navController) },
                    text = "Go To Cep Screen",
                    backgroundColor = greenApp,
                    textColor = Color.White
                )
            }
        }
    )
}