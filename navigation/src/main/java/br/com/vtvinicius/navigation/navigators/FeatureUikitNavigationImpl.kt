package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_uikit.FeatureUikitNavigation

class FeatureUikitNavigationImpl: FeatureUikitNavigation
{
    override fun goToLobby(navController: NavController) {
        navController.navigate("lobby_uikit")
    }
}