package br.com.vtvinicius.feature_canvas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.feature_canvas.animated_path.LobbyBackground
import br.com.vtvinicius.uikit.base.blueCanvasDark
import br.com.vtvinicius.uikit.base.blueCanvasLight
import br.com.vtvinicius.uikit.ui.button.FeaturesButton
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LobbyCanvas(
    navController: NavController,
    navigation: FeatureCanvasNavigation,
) {

    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Canvas",
                onBackPressed = { navigation.goBackToHome(navController = navController) },
                textColor = blueCanvasDark,
                backgroundColor = blueCanvasLight
            )
        },
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        scrollState
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Spacer(modifier = Modifier.height(24.dp))

                FeaturesButton(
                    onClick = { navigation.goToWeightPicker(navController) },
                    text = "weight_picker",
                    backgroundColor = blueCanvasLight,
                    textColor = blueCanvasDark
                )

                Spacer(modifier = Modifier.height(24.dp))

                FeaturesButton(
                    onClick = { navigation.goToClock(navController) },
                    text = "clock_screen",
                    backgroundColor = blueCanvasLight,
                    textColor = blueCanvasDark
                )

                Spacer(modifier = Modifier.height(24.dp))

                FeaturesButton(
                    onClick = { navigation.goToExamplePath(navController) },
                    text = "example_path",
                    backgroundColor = blueCanvasLight,
                    textColor = blueCanvasDark
                )

                Spacer(modifier = Modifier.height(24.dp))

                FeaturesButton(
                    onClick = { navigation.goToEffectPath(navController) },
                    text = "effect_path",
                    backgroundColor = blueCanvasLight,
                    textColor = blueCanvasDark
                )

                Spacer(modifier = Modifier.height(24.dp))

                FeaturesButton(
                    onClick = { navigation.goToGenderPicker(navController) },
                    text = "gender_picker_screen",
                    backgroundColor = blueCanvasLight,
                    textColor = blueCanvasDark
                )

                Spacer(modifier = Modifier.height(24.dp))

                FeaturesButton(
                    onClick = { navigation.goToLineGraph(navController) },
                    text = "line_graph",
                    backgroundColor = blueCanvasLight,
                    textColor = blueCanvasDark
                )

                Spacer(modifier = Modifier.height(24.dp))


            }
        }
    )
}
