package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_experiments.FeatureExperimentsNavigation

class FeatureExperimentsNavigationImpl : FeatureExperimentsNavigation {
    override fun goToLobby(navController: NavController) {
     navController.navigate("lobby_experiments")
    }

    override fun goToHomeFeature(navController: NavController) {
        navController.navigate("lobby_screen")
    }

    override fun goToMotionTopBar(navController: NavController) {
        navController.navigate("motion_top_bar")
    }
}