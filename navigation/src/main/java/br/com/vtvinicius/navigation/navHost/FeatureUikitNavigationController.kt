package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.feature_uikit.LobbyUikit
import br.com.vtvinicius.feature_uikit.buttons.ButtonScreen
import br.com.vtvinicius.feature_uikit.inputText.InputTextScreen
import br.com.vtvinicius.feature_uikit.neumorphism.NeumorphismScreen
import br.com.vtvinicius.feature_uikit.newinputtext.NewInputTextScreen
import br.com.vtvinicius.navigation.navigators.FeatureUikitNavigationImpl

@Composable
fun FeatureUikitNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_uikit"
    )
    {
        composable("lobby_uikit") {
            LobbyUikit(
                navController,
                FeatureUikitNavigationImpl()
            )
        }
        composable("lobby_screen") {
            FeatureHomeNavigationController()
        }
        composable("input_text") {
            InputTextScreen(
                navController,
                FeatureUikitNavigationImpl()
            )
        }
        composable("new_input_text") {
            NewInputTextScreen(
                navController,
                FeatureUikitNavigationImpl()
            )
        }
        composable("buttons") {
            ButtonScreen(
                navController,
                FeatureUikitNavigationImpl()
            )
        }
        composable("neumorphism") {
            NeumorphismScreen()
        }
    }
}
