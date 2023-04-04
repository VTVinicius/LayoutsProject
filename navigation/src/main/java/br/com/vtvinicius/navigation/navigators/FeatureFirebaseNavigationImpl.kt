package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_firebase.navigation.FeatureFirebaseNavigation

class FeatureFirebaseNavigationImpl: FeatureFirebaseNavigation {
    override fun goToLoginScreen(navController: NavController) {
        navController.navigate("login_screen")
    }

    override fun goToRegisterScreen(navController: NavController) {
        navController.navigate("register_screen")
    }

    override fun goToLoggedScreen(navController: NavController) {
        navController.navigate("logged_screen")
    }
}