package br.com.vtvinicius.feature_experiments

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
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.ui.button.FeaturesButton
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar


@Composable
fun ExperimentsLobby(
    navController: NavController,
    navigation: FeatureExperimentsNavigation,
) {

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Experimentos",
                onBackPressed = { navigation.goToHomeFeature(navController) },
                backgroundColor = greenExperimentsLight,
                textColor = greenExperimentsDark
            )
        },
        content = {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(background),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToMotionTopBar(navController = navController) },
                    text = "Motion Top Bar"
                )

            }


        }
    )

}
