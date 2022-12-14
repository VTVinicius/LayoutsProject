package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_example.navigation.FeatureExampleNavigation

class FeatureExampleNavigationImpl : FeatureExampleNavigation {

    override fun goToSecondScreen(navController: NavController) {
        navController.navigate("second_screen")
    }

    override fun goToHomeScreen(navController: NavController) {
        navController.navigate("home_screen")
    }

    override fun goBackToEntryPoint(navController: NavController) {
        navController.navigate("lobby_screen")
    }

    override fun goToCepScreen(navController: NavController) {
        navController.navigate("cep_screen")
    }

    override fun goToHistoryScreen(navController: NavController) {
        navController.navigate("history_screen")
    }

    override fun popBackStack(navController: NavController) {
        navController.popBackStack()
    }
}