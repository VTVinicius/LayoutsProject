package br.com.vtvinicius.feature_experiments.motion_layout.motion_top_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Slider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_experiments.FeatureExperimentsNavigation
import br.com.vtvinicius.feature_experiments.R
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.ui.text.HeadlineSmallText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar


@Composable
fun MotionTopBarScreen(navigation: FeatureExperimentsNavigation, navController: NavController) {

    var progress by remember {
        mutableStateOf(0f)
    }

    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Motion Top Bar",
                onBackPressed = { navigation.goToLobby(navController) },
                backgroundColor = greenExperimentsLight,
                textColor = greenExperimentsDark
            )
        },
        content = {


            Column {

                MotionTopBar(progress = progress)

                Spacer(modifier = Modifier.height(32.dp))

                Slider(
                    value = progress,
                    onValueChange = {
                        progress = it
                    },
                    modifier = Modifier.padding(horizontal = 32.dp)
                )

            }
        })
}


@OptIn(ExperimentalMotionApi::class)
@Composable
fun MotionTopBar(progress: Float) {

    val context = LocalContext.current

    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier.fillMaxWidth()
    ) {

        val properties = motionProperties(id = "profile_pic")
        val color = properties.value.color(name = "background")

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .layoutId("box")
        )

        Image(
            painter = painterResource(id = br.com.vtvinicius.uikit.R.drawable.profile_pic),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = color,
                    shape = CircleShape
                )
                .layoutId("profile_pic")
        )


        HeadlineSmallText(
            text = "Vinicius Teixeira",
            modifier = Modifier.layoutId("username"),
            colors = color,
        )
    }
}