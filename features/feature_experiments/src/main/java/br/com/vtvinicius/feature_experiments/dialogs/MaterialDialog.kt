package br.com.vtvinicius.feature_experiments.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.feature_experiments.FeatureExperimentsNavigation
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.base.redClonesDark
import br.com.vtvinicius.uikit.base.redClonesLight
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.text.BodyMediumText
import br.com.vtvinicius.uikit.ui.text.TitleLargeText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar

@Composable
fun MaterialDialogScreen(navigation: FeatureExperimentsNavigation, navController: NavController) {

    val openDialog = remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Dialogs",
                onBackPressed = { navigation.goToLobby(navController) },
                backgroundColor = greenExperimentsLight,
                textColor = greenExperimentsDark
            )
        },
        content = {

            Column(Modifier.fillMaxSize()) {

                AppButton(
                    onClick = { openDialog.value = true },
                    text = "Open Dialog",
                    backgroundColor = greenExperimentsLight,
                    textColor = greenExperimentsDark
                )

            }

            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    title = {
                        TitleLargeText(text = "Ops!")
                    },
                    text = {
                        BodyMediumText(
                            "Parece que ocorreu um erro, tente novamente mais tarde!",
                            align = TextAlign.Start
                        )
                    },
                    buttons = {
                        Row(
                            modifier = Modifier.padding(all = 8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            AppButton(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = { openDialog.value = false },
                                text = "Fechar",
                                textColor = redClonesDark,
                                backgroundColor = redClonesLight
                            )
                        }
                    }
                )

            }
        })
}