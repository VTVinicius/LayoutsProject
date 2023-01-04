package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.feature_home.features.FeaturesLobby
import br.com.vtvinicius.feature_home.lobby.LobbyScreen
import br.com.vtvinicius.navigation.navigators.FeatureHomeNavigationImpl

@Composable
fun FeatureHomeNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_screen"
    ) {
        composable("lobby_screen") {
            LobbyScreen(navController = navController, FeatureHomeNavigationImpl())
        }

        composable("feature_features") {
            FeaturesLobby(navController = navController, navigation = FeatureHomeNavigationImpl())
        }

        composable("feature_canvas") {
            FeatureCanvasNavigationController()
        }
        composable("feature_clones") {
            FeatureClonesNavigationController()
        }
        composable("feature_games") {
            FeatureGamesNavigationController()
        }
        composable("feature_uikit") {
            FeatureUikitNavigationController()
        }
        composable("feature_viacep") {
            FeatureViaCepNavigationController()
        }

    }
}