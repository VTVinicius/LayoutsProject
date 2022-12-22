package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.navigation.navigators.SocialMediaNavigationImpl
import br.com.vtvinicius.feature_clones.LobbySocialMedias
import br.com.vtvinicius.feature_clones.instagram.InstaProfileScreen
import br.com.vtvinicius.feature_clones.linkedin.LinkedinProfileScreen


@Composable
fun FeatureSocialMediaNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_social_medias"
    )
    {
        composable("lobby_social_medias") {
            br.com.vtvinicius.feature_clones.LobbySocialMedias(
                navController,
                SocialMediaNavigationImpl()
            )
        }
        composable("instagram") {
            br.com.vtvinicius.feature_clones.instagram.InstaProfileScreen()
        }
        composable("linkedin") {
            br.com.vtvinicius.feature_clones.linkedin.LinkedinProfileScreen()
        }
    }
}