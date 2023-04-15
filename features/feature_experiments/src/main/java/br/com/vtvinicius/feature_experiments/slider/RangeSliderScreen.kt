package br.com.vtvinicius.feature_experiments.slider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_experiments.FeatureExperimentsNavigation
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.base.redClonesDark
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


@Composable
fun RangeSliderScreen(navigation: FeatureExperimentsNavigation, navController: NavController) {
    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Range Sliders",
                onBackPressed = { navigation.goToLobby(navController) },
                backgroundColor = greenExperimentsLight,
                textColor = greenExperimentsDark
            )
        },
        content = {


    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RangeSlider()

        VerticalSpacer(height = 20)

        RangeSliderStep()

    }})
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RangeSlider() {

    var sliderPosition by remember { mutableStateOf(0f..100f) }

    Text(text = sliderPosition.toString())

    RangeSlider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..100f,
        onValueChangeFinished = {
            // launch some business logic update with the state you hold
            // viewModel.updateSelectedSliderValue(sliderPosition)
        },
    )

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RangeSliderStep() {
    var sliderPosition2 by remember { mutableStateOf(0f..100f) }

    Text(text = sliderPosition2.toString())

    RangeSlider(
        steps = 5,
        value = sliderPosition2,
        onValueChange = { sliderPosition2 = it },
        valueRange = 0f..100f,
        onValueChangeFinished = {
            // launch some business logic update with the state you hold
            // viewModel.updateSelectedSliderValue(sliderPosition)
        },
        colors = SliderDefaults.colors(
            thumbColor = Color.Red,
            activeTrackColor = redClonesDark
        )
    )

}