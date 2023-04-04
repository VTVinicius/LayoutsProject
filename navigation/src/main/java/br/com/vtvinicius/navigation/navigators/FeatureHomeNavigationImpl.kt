package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_home.navigation.FeatureHomeNavigation

class FeatureHomeNavigationImpl : FeatureHomeNavigation {

    override fun goToFeatures(navController: NavController) {
        navController.navigate("feature_features")
    }

    override fun goToFeatureClones(navController: NavController) {
        navController.navigate("feature_clones")
    }

    override fun goToFeatureCanvas(navController: NavController) {
        navController.navigate("feature_canvas")
    }

    override fun goToFeatureGames(navController: NavController) {
        navController.navigate("feature_games")
    }

    override fun goToFeatureUikit(navController: NavController) {
        navController.navigate("feature_uikit")
    }

    override fun goToFeatureExperiments(navController: NavController) {
        navController.navigate("feature_experiments")
    }

    override fun goToFeatureViaCep(navController: NavController) {
        navController.navigate("feature_viacep")
    }
    override fun goToFeatureFirebase(navController: NavController) {
        navController.navigate("feature_firebase")
    }
}