package br.com.vtvinicius.feature_clones

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.uikit.base.background
import br.com.vtvinicius.uikit.base.redClonesDark
import br.com.vtvinicius.uikit.base.redClonesLight
import br.com.vtvinicius.uikit.ui.button.FeaturesButton
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun LobbySocialMedias(navController: NavController, navigation: FeatureClonesNavigation) {


    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Clones",
                onBackPressed = { navigation.goBackToHome(navController = navController) },
                textColor = redClonesDark,
                backgroundColor = redClonesLight
            )
        },
        content = {


            Column(
                Modifier
                    .fillMaxSize()
                    .background(background),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                VerticalSpacer(height = 24)

                FeaturesButton(
                    onClick = { navigation.goToInstagram(navController) },
                    text = "Instagram",
                    backgroundColor = redClonesLight,
                    textColor = redClonesDark
                )

                VerticalSpacer(height = 24)

                FeaturesButton(
                    onClick = { navigation.goToLinkedin(navController) },
                    text = "Linkedin",
                    backgroundColor = redClonesLight,
                    textColor = redClonesDark
                )

                VerticalSpacer(height = 24)

            }
        })
}