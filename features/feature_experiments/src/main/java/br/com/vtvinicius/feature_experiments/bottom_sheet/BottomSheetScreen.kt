package br.com.vtvinicius.feature_experiments.bottom_sheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.feature_experiments.FeatureExperimentsNavigation
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.text.BodyMediumText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import kotlinx.coroutines.launch


@Composable
@OptIn(ExperimentalMaterialApi::class)
fun BottomSheetScreen(navigation: FeatureExperimentsNavigation, navController: NavController) {


    Scaffold(
        topBar = {
            AppTopBar(
                title = "Bottom Sheets",
                onBackPressed = { navigation.goToLobby(navController) },
                backgroundColor = greenExperimentsLight,
                textColor = greenExperimentsDark
            )
        },
        content = {

            val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
            val scope = rememberCoroutineScope()
            var skipHalfExpanded by remember { mutableStateOf(false) }
            val state2 = rememberModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden,
                skipHalfExpanded = skipHalfExpanded
            )

            ModalBottomSheetLayout(
                sheetState = state,
                sheetContent = {
                    LazyColumn {
                        items(50) {
                            ListItem(
                                text = { Text("Item $it") },
                                icon = {
                                    Icon(
                                        Icons.Default.Favorite,
                                        contentDescription = "Localized description"
                                    )
                                }
                            )
                        }
                    }
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BodyMediumText("Rest of the UI")
                    VerticalSpacer(20)
                    AppButton(
                        onClick = { scope.launch { state.show() } },
                        text = "Click to show sheet",
                        backgroundColor = greenExperimentsLight,
                        textColor = greenExperimentsDark
                    )
                    VerticalSpacer(height = 50)
                    Row(
                        Modifier.toggleable(
                            value = skipHalfExpanded,
                            role = Role.Checkbox,
                            onValueChange = { checked -> skipHalfExpanded = checked }
                        )
                    ) {
                        Checkbox(checked = skipHalfExpanded, onCheckedChange = null)
                        HorizontalSpacer(16)
                        BodyMediumText("Skip Half Expanded State")
                    }
                    VerticalSpacer(20)
                    AppButton(
                        onClick = { scope.launch { state2.show() } },
                        text = "Click to show sheet 2",
                        backgroundColor = greenExperimentsLight,
                        textColor = greenExperimentsDark
                    )
                }
            }

            ModalBottomSheetLayout(
                sheetState = state2,
                sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                sheetContent = {
                    LazyColumn {
                        items(50) {
                            ListItem(
                                text = { BodyMediumText("Item $it") },
                                icon = {
                                    Icon(
                                        Icons.Default.Call,
                                        contentDescription = "Localized description"
                                    )
                                }
                            )
                        }
                    }
                },
            ) {}
        }
    )
}