package br.com.vtvinicius.feature_experiments.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.base.redClonesDark
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun CheckBoxes() {
    Column() {

        Column {
            // define dependent checkboxes states
            val (state, onStateChange) = remember { mutableStateOf(true) }
            val (state2, onStateChange2) = remember { mutableStateOf(true) }
            val (state3, onStateChange3) = remember { mutableStateOf(true) }
            val (state4, onStateChange4) = remember { mutableStateOf(true) }

            // TriStateCheckbox state reflects state of dependent checkboxes
            val parentState = remember(state, state2, state3, state4) {
                if (state && state2 && state3 && state4) androidx.compose.ui.state.ToggleableState.On
                else if (!state && !state2 && !state3 && !state4) androidx.compose.ui.state.ToggleableState.Off
                else androidx.compose.ui.state.ToggleableState.Indeterminate
            }
            // click on TriStateCheckbox can set state for dependent checkboxes
            val onParentClick = {
                val s = parentState != androidx.compose.ui.state.ToggleableState.On
                onStateChange(s)
                onStateChange2(s)
                onStateChange3(s)
                onStateChange4(s)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {

                TriStateCheckbox(
                    state = parentState,
                    onClick = onParentClick,
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colors.primary
                    )
                )
                Text(text = "Adicionais")
            }
            Spacer(Modifier.size(8.dp))
            Column(Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(state, onStateChange)
                    Text(text = "Queijo")
                }
                Spacer(Modifier.size(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(state2, onStateChange2)
                    Text(text = "Presunto")
                }
                Spacer(Modifier.size(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(state3, onStateChange3)
                    Text(text = "Maionese")
                }
                Spacer(Modifier.size(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(state4, onStateChange4)
                    Text(text = "Bacon")
                }
            }
        }
        VerticalSpacer(height = 100)

        Column() {


            val checkedState1 = remember { mutableStateOf(true) }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checkedState1.value,
                    onCheckedChange = { checkedState1.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Red,
                        uncheckedColor = redClonesDark
                    )
                )
                Text(text = "Option 1")
            }
            val checkedState2 = remember { mutableStateOf(true) }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checkedState2.value,
                    onCheckedChange = { checkedState2.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Red,
                        uncheckedColor = redClonesDark
                    )
                )
                Text(text = "Option 2")
            }
            val checkedState3 = remember { mutableStateOf(true) }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checkedState3.value,
                    onCheckedChange = { checkedState3.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Red,
                        uncheckedColor = redClonesDark
                    )
                )
                Text(text = "Option 3")
            }
        }
    }
}