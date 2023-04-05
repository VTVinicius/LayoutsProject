package br.com.vtvinicius.feature_firebase.login

import EmailInputText
import PasswordInputText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_firebase.navigation.FeatureFirebaseNavigation
import br.com.vtvinicius.uikit.base.greenFeatures
import br.com.vtvinicius.uikit.base.greenFeaturesDark
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.inputtext.base.InputTextState
import br.com.vtvinicius.uikit.ui.text.TitleMediumText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginFirebaseScreen(
    navController: NavController,
    navigation: FeatureFirebaseNavigation
) {
    val viewModel = getViewModel<LoginViewModel>()
    var email by remember { mutableStateOf("a") }
    var password by remember { mutableStateOf("a") }
    val state by viewModel.state.collectAsState()



    LaunchedEffect(key1 = true) {
        viewModel.isUserLogged()
    }

    LaunchedEffect(key1 = state) {
        if (state.isUserLogged) {
            navigation.goToLoggedScreen(navController)
        }
    }


    AppScaffold(topBar = {
        AppTopBar(
            title = "Login",
            backgroundColor = greenFeatures,
            textColor = greenFeaturesDark
        )
    }, content = {


        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            TitleMediumText(text = "Email")

            VerticalSpacer(height = 16)

            EmailInputText(onSearch = { email = it }, state = InputTextState.OUTLINE)

            VerticalSpacer(height = 16)

            TitleMediumText(text = "Senha")

            VerticalSpacer(height = 16)

            PasswordInputText(onSearch = { password = it })

            VerticalSpacer(height = 16)



            AppButton(
                onClick = {
                    viewModel.login(email, password)
                },
                text = "Entrar",
                backgroundColor = greenFeatures,
                textColor = greenFeaturesDark
            )

            VerticalSpacer(height = 56)
            AppButton(
                onClick = { navigation.goToRegisterScreen(navController) },
                text = "Registrar",
                backgroundColor = greenFeatures,
                textColor = greenFeaturesDark
            )

        }

    })

}