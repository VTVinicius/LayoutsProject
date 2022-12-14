package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.feature_example.cepScreen.CepScreen
import br.com.vtvinicius.feature_example.history.HistoryScreen
import br.com.vtvinicius.feature_example.homeScreen.HomeScreen
import br.com.vtvinicius.feature_example.secondScreen.SecondScreen
import br.com.vtvinicius.navigation.navigators.FeatureExampleNavigationImpl

@Composable
fun FeatureExampleNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home_screen"
    )
    {
        composable("home_screen") {
            HomeScreen(
                navController,
                FeatureExampleNavigationImpl()
            )
        }
        composable("second_screen") {
            SecondScreen(
                navController,
                FeatureExampleNavigationImpl()
            )
        }
        composable("lobby_screen") {
            EntryPointHostController()
        }

        composable("cep_screen") {
            CepScreen(
                navController,
                FeatureExampleNavigationImpl()
            )
        }
        composable("history_screen") {
            HistoryScreen(
                navController,
                FeatureExampleNavigationImpl()
            )
        }
    }
}