package br.com.vtvinicius.feature_uikit.newinputtext

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_uikit.FeatureUikitNavigation
import br.com.vtvinicius.uikit.base.purpleUikitDark
import br.com.vtvinicius.uikit.base.purpleUikitLight
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.newTextField.DefaultTextField
import br.com.vtvinicius.uikit.ui.newTextField.NormalTextField
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


@Composable
fun NewInputTextScreen(
    navController: NavController,
    navigation: FeatureUikitNavigation
) {


    var validation by remember {
        mutableStateOf(true)
    }

    AppScaffold(content =
    {

        Column {

            NormalTextField(
                text = {

                },
                isSuccess = {

                }
            )

            VerticalSpacer(height = 16)

            DefaultTextField(
                text = {

                },
                isSuccess = {

                },
                validationBoolean = validation
            )


            VerticalSpacer(height = 16)

            AppButton(
                onClick = { validation = !validation },
                text = "Validar",
                backgroundColor = purpleUikitLight,
                textColor = purpleUikitDark
            )
        }
    }
    )
}