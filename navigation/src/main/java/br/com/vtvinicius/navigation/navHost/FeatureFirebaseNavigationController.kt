package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.feature_firebase.logged.LoggedFirebaseScreen
import br.com.vtvinicius.feature_firebase.login.LoginFirebaseScreen
import br.com.vtvinicius.feature_firebase.register.RegisterFirebaseScreen
import br.com.vtvinicius.navigation.navigators.FeatureExampleNavigationImpl
import br.com.vtvinicius.viacep.homeScreen.HomeScreen

@Composable
fun FeatureFirebaseNavigationController() {


    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login_screen"
    )
    {
        composable("login_screen") {
            LoginFirebaseScreen(
            )
        }
        composable("register_screen") {
            RegisterFirebaseScreen(

            )
        }
        composable("logged_screen") {
            LoggedFirebaseScreen(
            )
        }
    }
}