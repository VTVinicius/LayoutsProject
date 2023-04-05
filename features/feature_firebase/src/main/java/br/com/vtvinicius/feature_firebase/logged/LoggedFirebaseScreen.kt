package br.com.vtvinicius.feature_firebase.logged

import androidx.activity.compose.BackHandler
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_firebase.navigation.FeatureFirebaseNavigation
import br.com.vtvinicius.uikit.base.greenFeatures
import br.com.vtvinicius.uikit.base.greenFeaturesDark
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar

@Composable
fun LoggedFirebaseScreen(
    navController: NavController,
    navigation: FeatureFirebaseNavigation
) {

    BackHandler {
        navigation.goBackToHome(navController)
    }

    AppScaffold(topBar = {
        AppTopBar(
            title = "Logged",
            backgroundColor = greenFeatures,
            textColor = greenFeaturesDark,
            onBackPressed = { navigation.goToPreLoginScreen(navController) }
        )
    }, content = {
        Text(text = "Logged")

    }
    )


}