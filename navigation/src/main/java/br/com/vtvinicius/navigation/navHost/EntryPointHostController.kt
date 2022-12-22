package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.base_feature.lobby.LobbyScreen
import br.com.vtvinicius.navigation.navigators.EntryPointNavigationImpl

@Composable
fun EntryPointHostController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_screen"
    ) {
        composable("lobby_screen") {
            LobbyScreen(navController = navController, EntryPointNavigationImpl())
        }

        composable("feature_viacep") {
            FeatureExampleNavigationController()
        }

        composable("feature_canvas") {
            FeatureCanvasNavigationController()
        }
        composable("feature_clones") {
            FeatureSocialMediaNavigationController()
        }
    }
}