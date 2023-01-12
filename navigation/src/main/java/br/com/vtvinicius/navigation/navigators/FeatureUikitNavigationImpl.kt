package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_uikit.FeatureUikitNavigation

class FeatureUikitNavigationImpl : FeatureUikitNavigation {
    override fun goToLobbyUikit(navController: NavController) {
        navController.navigate("lobby_uikit")
    }

    override fun goToInputText(navController: NavController) {
        navController.navigate("input_text")
    }

    override fun goBackToHome(navController: NavController) {
        navController.navigate("lobby_screen")
    }

    override fun popBackStack(navController: NavController) {
        navController.popBackStack()
    }

    override fun goToButtons(navController: NavController) {
        navController.navigate("buttons")
    }
}