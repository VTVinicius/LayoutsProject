package br.com.vtvinicius.feature_firebase.register

import EmailInputText
import PasswordInputText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.uikit.base.greenFeatures
import br.com.vtvinicius.uikit.base.greenFeaturesDark
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.inputtext.base.InputTextState
import br.com.vtvinicius.uikit.ui.text.TitleMediumText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import org.koin.androidx.compose.getViewModel

@Composable
fun RegisterFirebaseScreen() {

    val viewModel = getViewModel<RegisterViewModel>()

    AppScaffold(topBar = {
        AppTopBar(
            title = "Register",
            textColor = greenFeaturesDark,
            backgroundColor = greenFeatures
        )
    }, content = {

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(Modifier.fillMaxSize()) {

            TitleMediumText(text = "Email", modifier = Modifier.padding(horizontal = 16.dp))

            VerticalSpacer(height = 8)

            EmailInputText(
                onSearch = { email = it },
                state = InputTextState.OUTLINE,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            VerticalSpacer(height = 16)

            TitleMediumText(text = "Password", modifier = Modifier.padding(horizontal = 16.dp))

            VerticalSpacer(height = 8)

            PasswordInputText(
                onSearch = { password = it },
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            VerticalSpacer(height = 16)

            AppButton(
                onClick = { viewModel.register(email, password) },
                text = "Register",
                backgroundColor = greenFeatures,
                textColor = greenFeaturesDark, modifier = Modifier.padding(horizontal = 16.dp)
            )

        }

    }
    )


}