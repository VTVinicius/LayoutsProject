package br.com.vtvinicius.feature_experiments.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.feature_experiments.FeatureExperimentsNavigation
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar


@Composable
fun SwitchButtonsScreen(navigation: FeatureExperimentsNavigation, navController: NavController) {

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Switch Buttons",
                onBackPressed = { navigation.goToLobby(navController) },
                backgroundColor = greenExperimentsLight,
                textColor = greenExperimentsDark
            )
        },
        content = {


            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SwitchButtons()
            }
        })

}

@Composable
fun SwitchButtons() {

    val checkedState = remember { mutableStateOf(true) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )

    var pineappleOnPizza by remember { mutableStateOf(true) }
    var pizzaOnPineapple by remember { mutableStateOf(true) }


    Row(
        Modifier
            .padding(16.dp)
            .toggleable(
                role = Role.Switch,
                value = pineappleOnPizza,
                onValueChange = { pineappleOnPizza = it },
            )
    ) {
        Switch(checked = pineappleOnPizza, onCheckedChange = null)

        Spacer(Modifier.width(8.dp))

        Text("Pineapple on pizza?")
    }
    Row(
        Modifier
            .padding(16.dp)
            .toggleable(
                role = Role.Switch,
                value = pizzaOnPineapple,
                onValueChange = { pizzaOnPineapple = it },
            )
    ) {
        Switch(checked = pizzaOnPineapple, onCheckedChange = null)

        Spacer(Modifier.width(8.dp))

        Text("Pizza on pineapple?")
    }

}