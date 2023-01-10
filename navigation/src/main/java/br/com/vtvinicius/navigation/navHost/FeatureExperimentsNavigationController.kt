package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.feature_experiments.ExperimentsLobby
import br.com.vtvinicius.feature_experiments.motion_layout.motion_top_bar.MotionTopBarScreen
import br.com.vtvinicius.navigation.navigators.FeatureExperimentsNavigationImpl

@Composable
fun FeatureExperimentsNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_experiments"
    ) {
        composable("lobby_experiments") {
            ExperimentsLobby(navController, FeatureExperimentsNavigationImpl())
        }
        composable("lobby_screen") {
            FeatureHomeNavigationController()
        }
        composable("motion_top_bar") {
            MotionTopBarScreen()
        }
    }
}