package br.com.vtvinicius.feature_experiments.shimmer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.feature_experiments.FeatureExperimentsNavigation
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import kotlinx.coroutines.delay


@Composable
fun ShimmerScreen(navigation: FeatureExperimentsNavigation, navController: NavController) {

    var isLoading by remember {
        mutableStateOf(true)
    }


    //Simulate a Six Seconds Loading
    LaunchedEffect(key1 = true) {
        delay(6000)
        isLoading = false
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = if (isLoading) "Loading" else "ShimmerEffect",
                backgroundColor = greenExperimentsLight,
                textColor = greenExperimentsDark,
                onBackPressed = { navigation.goToLobby(navController = navController) }
            )
        },
        content = {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                LazyColumn {

                    items(4) {

                        ShimmerListItem(
                            isLoading = isLoading,
                            contentAfterLoading = {

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                ) {

                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = null,
                                        modifier = Modifier.size(100.dp)
                                    )

                                    Spacer(modifier = Modifier.width(16.dp))

                                    Text(
                                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus aliquet " +
                                                "ipsum non tellus ullamcorper accumsan. "
                                    )

                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    }

                }

                VerticalSpacer(height = 24)

                ShimmerButtonItem(
                    isLoading = isLoading,
                    contentAfterLoading = {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {

                            AppButton(
                                onClick = { },
                                text = "Clique Aqui!",
                                backgroundColor = greenExperimentsLight,
                                textColor = greenExperimentsDark
                            )

                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        })
}