package br.com.vtvinicius.feature_canvas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.vtvinicius.feature_canvas.animated_path.LobbyBackground
import br.com.vtvinicius.uikit.ui.button.AppButton


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LobbyCanvas(
    navController: NavController,
    navigation: FeatureCanvasNavigation
) {


    val scrollState = rememberScrollState()
    Scaffold(
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

                LobbyBackground()

                Spacer(modifier = Modifier.height(24.dp))

                Text(text = "Exemplos de Layouts com Canvas!", fontSize = 24.sp)

                Spacer(modifier = Modifier.height(24.dp))

                Spacer(modifier = Modifier.height(24.dp))

                AppButton(
                    onClick = { navigation.goToWeightPicker(navController) },
                    text = "weight_picker"
                )

                Spacer(modifier = Modifier.height(24.dp))

                AppButton(
                    onClick = { navigation.goToClock(navController) },
                    text = "clock_screen",
                )

                Spacer(modifier = Modifier.height(24.dp))

                AppButton(
                    onClick = { navigation.goToExamplePath(navController) },
                    text = "example_path"
                )

                Spacer(modifier = Modifier.height(24.dp))

                AppButton(
                    onClick = { navigation.goToEffectPath(navController) },
                    text = "effect_path",
                )

                Spacer(modifier = Modifier.height(24.dp))

                AppButton(
                    onClick = { navigation.goToGenderPicker(navController) },
                    text = "gender_picker_screen"
                )

                Spacer(modifier = Modifier.height(24.dp))

                AppButton(
                    onClick = { navigation.goToLineGraph(navController) },
                    text = "line_graph"
                )

                Spacer(modifier = Modifier.height(24.dp))


            }
        }
    )
}
