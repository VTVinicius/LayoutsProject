package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.navigation.navigators.SocialMediaNavigationImpl
import com.example.feature_social_media.LobbySocialMedias
import com.example.feature_social_media.instagram.InstaProfileScreen
import com.example.feature_social_media.linkedin.LinkedinProfileScreen


@Composable
fun FeatureSocialMediaNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_social_medias"
    )
    {
        composable("lobby_social_medias") {
            LobbySocialMedias(
                navController,
                SocialMediaNavigationImpl()
            )
        }
        composable("instagram") {
            InstaProfileScreen()
        }
        composable("linkedin") {
            LinkedinProfileScreen()
        }
    }
}