package br.com.vtvinicius.feature_firebase.pre_login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_firebase.login.LoginViewModel
import br.com.vtvinicius.feature_firebase.navigation.FeatureFirebaseNavigation
import br.com.vtvinicius.uikit.base.greenFeatures
import br.com.vtvinicius.uikit.base.greenFeaturesDark
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import org.koin.androidx.compose.getViewModel

@Composable
fun PreLoginScreen(
    navController: NavController,
    navigation: FeatureFirebaseNavigation
) {

    val viewModel = getViewModel<LoginViewModel>()
    val state by viewModel.state.collectAsState()


    LaunchedEffect(key1 = true) {
        viewModel.isUserLogged()
    }


    AppScaffold(topBar = {
        AppTopBar(
            title = "Feature Firebase",
            backgroundColor = greenFeatures,
            textColor = greenFeaturesDark,
            onBackPressed = { navigation.goBackToHome(navController) }
        )
    }, content = {

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            AppButton(
                onClick = {
                    if (state.isUserLogged) navigation.goToLoggedScreen(navController) else navigation.goToLoginScreen(
                        navController
                    )
                },
                text = "Login Firebase",
                backgroundColor = greenFeatures,
                textColor = greenFeaturesDark
            )

        }

    })

}