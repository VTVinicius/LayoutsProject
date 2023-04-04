package br.com.vtvinicius.feature_home.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_home.navigation.FeatureHomeNavigation
import br.com.vtvinicius.uikit.base.background
import br.com.vtvinicius.uikit.base.greenFeatures
import br.com.vtvinicius.uikit.base.greenFeaturesDark
import br.com.vtvinicius.uikit.ui.button.FeaturesButton
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun FeaturesLobby(
    navController: NavController,
    navigation: FeatureHomeNavigation,
) {

    AppScaffold(
        topBar = {
            AppTopBar(
                backgroundColor = greenFeatures,
                textColor = greenFeaturesDark,
                onBackPressed = { navController.popBackStack() },
                title = "Features"
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
                    backgroundColor = greenFeatures,
                    textColor = greenFeaturesDark,
                    text = "ViaCep",
                    onClick = { navigation.goToFeatureViaCep(navController) }
                )

                VerticalSpacer(height = 24)

                FeaturesButton(
                    backgroundColor = greenFeatures,
                    textColor = greenFeaturesDark,
                    text = "Login Firebase",
                    onClick = { navigation.goToFeatureFirebase(navController) }
                )

                VerticalSpacer(height = 24)

            }
        })
}
