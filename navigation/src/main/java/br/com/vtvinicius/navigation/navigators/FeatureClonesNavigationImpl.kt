package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_clones.FeatureClonesNavigation

class FeatureClonesNavigationImpl: FeatureClonesNavigation
{
    override fun goToInstagram(navController: NavController) {
        navController.navigate("instagram")
    }

    override fun goToLinkedin(navController: NavController) {
   navController.navigate("linkedin")
    }

    override fun goToLobby(navController: NavController) {
        navController.navigate(" lobby_clones")
    }

    override fun goBackToHome(navController: NavController) {
        navController.navigate("lobby_screen")
    }
}