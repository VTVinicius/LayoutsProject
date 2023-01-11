package br.com.vtvinicius.feature_experiments.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.base.redClonesDark
import br.com.vtvinicius.uikit.base.redClonesLight
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.text.BodyMediumText
import br.com.vtvinicius.uikit.ui.text.TitleLargeText
import br.com.vtvinicius.uikit.ui.text.TitleMediumText
import br.com.vtvinicius.uikit.ui.text.TitleSmallText

@Composable
fun MaterialDialogScreen() {
    val openDialog = remember { mutableStateOf(true) }

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
                TitleLargeText(text = "Title")
            },
            text = {
                BodyMediumText(
                    "This area typically contains the supportive text " +
                            "which presents the details regarding the Dialog's purpose."
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
                        text = "Dismiss",
                        textColor = redClonesDark,
                        backgroundColor = redClonesLight
                    )
                }
            }
        )
    }

}