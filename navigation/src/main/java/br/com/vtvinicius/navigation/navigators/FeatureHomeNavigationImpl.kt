package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_home.lobby.FeatureHomeNavigation

class FeatureHomeNavigationImpl : FeatureHomeNavigation {

    override fun goToFeatureViaCep(navController: NavController) {
        navController.navigate("feature_viacep")
    }

    override fun goToFeatureClones(navController: NavController) {
        navController.navigate("feature_clones")
    }

    override fun goToFeatureCanvas(navController: NavController) {
        navController.navigate("feature_canvas")
    }
}