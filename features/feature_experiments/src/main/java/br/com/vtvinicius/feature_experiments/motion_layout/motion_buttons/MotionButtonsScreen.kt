package br.com.vtvinicius.feature_experiments.motion_layout.motion_buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import br.com.vtvinicius.feature_experiments.R
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.ui.button.FeaturesButton
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import kotlinx.coroutines.delay

@Composable
fun MotionButtonsScreen() {
    Column {

        var progress by remember {
            mutableStateOf(0f)
        }

        //dalay to incress progress
        LaunchedEffect(key1 = progress) {
            delay(10)
            if (progress <= 1f) {
                progress += 0.05f
            }
        }

        Slider(
            value = progress,
            onValueChange = {
                progress = it
            },
            modifier = Modifier.padding(horizontal = 32.dp)
        )

        MotionButton(progress = progress)

        VerticalSpacer(height = 32)

        MotionButton(progress = progress)

        VerticalSpacer(height = 32)

        MotionButton(progress = progress)

        VerticalSpacer(height = 32)

        MotionButton(progress = progress)

        VerticalSpacer(height = 32)

        MotionButton(progress = progress)
    }
}

@OptIn(ExperimentalMotionApi::class)
@Composable
fun MotionButton(progress: Float) {

    val context = LocalContext.current

    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.buttons_scene)
            .readBytes()
            .decodeToString()
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier.fillMaxWidth()
    ) {
        FeaturesButton(
            text = if (progress >= 0.6f) "Botão Completo" else "",
            modifier = Modifier
                .layoutId("buttons"),
            backgroundColor = greenExperimentsLight,
            textColor = greenExperimentsDark,
            onClick = {}
        )
    }
}