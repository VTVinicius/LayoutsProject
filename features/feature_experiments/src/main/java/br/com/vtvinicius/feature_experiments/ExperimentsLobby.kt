package br.com.vtvinicius.feature_experiments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


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

            val scrollState = rememberScrollState()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(background)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToMotionTopBar(navController = navController) },
                    text = "Motion Top Bar"
                )

                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToMotionButtons(navController = navController) },
                    text = "Motion Buttons"
                )

                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToBottomSheet1(navController = navController) },
                    text = "Bottom Sheet 1"
                )

                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToSideModal1(navController = navController) },
                    text = "Side Modal 1"
                )

                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToDialogs1(navController = navController) },
                    text = "Dialog 1"
                )

                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToRadioButtonsScreen(navController = navController) },
                    text = "Radio Buttons"
                )

                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToCheckBoxesScreen(navController = navController) },
                    text = "Check Boxes"
                )
                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToProductsPagerScreen(navController = navController) },
                    text = "Products Pager"
                )

                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToCarouselScreen(navController = navController) },
                    text = "Carousel Pager"
                )

                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToRangeSliderScreen(navController = navController) },
                    text = "Range Slider"
                )

                VerticalSpacer(height = 20)

                FeaturesButton(
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark,
                    onClick = { navigation.goToShimmerScreen(navController = navController) },
                    text = "Shimmer Effect"
                )

                VerticalSpacer(height = 20)
                
            }


        }
    )

}
