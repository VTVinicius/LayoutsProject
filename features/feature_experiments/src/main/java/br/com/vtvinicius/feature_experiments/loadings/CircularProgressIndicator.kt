package br.com.vtvinicius.feature_experiments.loadings

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_experiments.FeatureExperimentsNavigation
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun ProgressIndicatorScreen(
    navController: NavController,
    navigation: FeatureExperimentsNavigation
) {
    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Progress Indicators",
                onBackPressed = { navigation.goToLobby(navController) },
                backgroundColor = greenExperimentsLight,
                textColor = greenExperimentsDark
            )
        },
        content = {

            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                ProgressIndicatorsComp()

            }
        })

}

@Composable
fun ProgressIndicatorsComp() {
    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        BoxWithConstraints(contentAlignment = Alignment.Center) {
            Text(text = "${(animatedProgress * 100).toInt()}%")
            CircularProgressIndicator(progress = animatedProgress, modifier = Modifier.size(75.dp))
            Spacer(Modifier.requiredHeight(30.dp))

            VerticalSpacer(height = 80)

        }

        VerticalSpacer(height = 80)

        LinearProgressIndicator(progress = animatedProgress)

        VerticalSpacer(height = 50)
        BoxWithConstraints(contentAlignment = Alignment.Center) {
            LinearProgressIndicator(
                progress = animatedProgress, modifier = Modifier
                    .height(52.dp)
                    .clip(
                        RoundedCornerShape(12.dp)
                    )
                    .border(1.dp, greenExperimentsDark, RoundedCornerShape(12.dp)),
                backgroundColor = greenExperimentsLight,
                color = greenExperimentsDark
            )
            Text(
                text = "${(animatedProgress * 100).toInt()}%",
                color = if (animatedProgress < 0.45) Color.Black else Color.White
            )
        }
        VerticalSpacer(height = 50)
        OutlinedButton(
            onClick = {
                if (progress < 1f) progress += 0.1f else progress = 0.1f
            }
        ) {
            Text("Increase")
        }
    }

}

