package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import com.example.feature_social_media.SocialMediaNavigation

class SocialMediaNavigationImpl: SocialMediaNavigation
{
    override fun goToInstagram(navController: NavController) {
        navController.navigate("instagram")
    }

    override fun goToLobby(navController: NavController) {
        navController.navigate(" lobby_social_medias")
    }
}