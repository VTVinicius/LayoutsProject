package br.com.vtvinicius.feature_uikit.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_uikit.FeatureUikitNavigation
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.*
import br.com.vtvinicius.uikit.ui.button.*
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun ButtonScreen(navController: NavController, navigation: FeatureUikitNavigation) {


    var buttonColor by remember {
        mutableStateOf(purpleUikitLight)
    }

    var textColor by remember {
        mutableStateOf(purpleUikitDark)
    }

    val rowState = rememberLazyListState()


    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Botões",
                onBackPressed = { navigation.popBackStack(navController = navController) },
                backgroundColor = purpleUikitLight, textColor = purpleUikitDark
            )
        }, content = {

            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                VerticalSpacer(height = 24)

                LazyRow(state = rowState,
                    content = {
                        item {
                            HorizontalSpacer(width = 8)
                            SmallButton(
                                backgroundColor = greenFeatures,
                                textColor = greenFeaturesDark,
                                onClick = {
                                    buttonColor = greenFeatures; textColor = greenFeaturesDark
                                },
                                text = "Green Features",
                                modifier = Modifier.size(width = 132.dp, height = 84.dp)
                            )
                            HorizontalSpacer(width = 8)
                            SmallButton(
                                backgroundColor = blueCanvasLight,
                                textColor = blueCanvasDark,
                                onClick = {
                                    buttonColor = blueCanvasLight; textColor = blueCanvasDark
                                },
                                text = "Blue Canvas",
                                modifier = Modifier.size(width = 132.dp, height = 84.dp)
                            )
                            HorizontalSpacer(width = 8)
                            SmallButton(
                                backgroundColor = yellowGamesLight,
                                textColor = yellowGamesDark,
                                onClick = {
                                    buttonColor = yellowGamesLight; textColor = yellowGamesDark
                                },
                                text = "Yellow Games",
                                modifier = Modifier.size(width = 132.dp, height = 84.dp)
                            )
                            HorizontalSpacer(width = 8)
                            SmallButton(
                                backgroundColor = redClonesLight,
                                textColor = redClonesDark,
                                onClick = {
                                    buttonColor = redClonesLight; textColor = redClonesDark
                                },
                                text = "Red Clones",
                                modifier = Modifier.size(width = 132.dp, height = 84.dp)
                            )
                            HorizontalSpacer(width = 8)
                            SmallButton(
                                backgroundColor = purpleUikitLight,
                                textColor = purpleUikitDark,
                                onClick = {
                                    buttonColor = purpleUikitLight; textColor = purpleUikitDark
                                },
                                text = "Purple UiKit",
                                modifier = Modifier.size(width = 132.dp, height = 84.dp)
                            )
                            HorizontalSpacer(width = 8)
                            SmallButton(
                                backgroundColor = greenExperimentsLight,
                                textColor = greenExperimentsDark,
                                onClick = {
                                    buttonColor = greenExperimentsLight; textColor =
                                    greenExperimentsDark
                                },
                                text = "Green Experiments",
                                modifier = Modifier.size(width = 132.dp, height = 84.dp)
                            )
                            HorizontalSpacer(width = 8)
                        }
                    }
                )

                VerticalSpacer(height = 52)


                FeaturesButton(
                    backgroundColor = buttonColor,
                    textColor = textColor,
                    onClick = { /*TODO*/ },
                    text = "Features Button"
                )

                VerticalSpacer(height = 16)

                AppButton(
                    onClick = { /*TODO*/ },
                    text = "AppButton",
                    backgroundColor = buttonColor,
                    textColor = textColor
                )

                VerticalSpacer(height = 16)

                CircularIconButton(
                    onClick = { /*TODO*/ },
                    buttonColor = buttonColor,
                    icon = R.drawable.ic_plus,
                )

                VerticalSpacer(height = 16)

                RoundedButtons(
                    buttonColor = buttonColor,
                    textColor = textColor,
                    onClick = { /*TODO*/ },
                    text = "Rounded Button",
                    textModifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
                VerticalSpacer(height = 16)

                SmallButton(
                    text = "SmallButton",
                    textColor = textColor,
                    backgroundColor = buttonColor,
                    onClick = {}
                ) 
                
                VerticalSpacer(height = 16)
                
                CounterButton(onClickAdd = { /*TODO*/ }, onClickRemove = { /*TODO*/ })

                VerticalSpacer(height = 16)
            }
        })
}