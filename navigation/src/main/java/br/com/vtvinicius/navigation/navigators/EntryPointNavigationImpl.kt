package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.loby.EntryPointNavigation

class EntryPointNavigationImpl : EntryPointNavigation {

    override fun goToFeatureExample(navController: NavController) {
        navController.navigate("feature_example")
    }

    override fun goToFeatureSocialMedia(navController: NavController) {
        navController.navigate("feature_social_media")
    }
}