package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.feature_clones.LobbySocialMedias
import br.com.vtvinicius.feature_clones.instagram.InstaProfileScreen
import br.com.vtvinicius.feature_clones.linkedin.LinkedinProfileScreen
import br.com.vtvinicius.navigation.navigators.FeatureClonesNavigationImpl


@Composable
fun FeatureClonesNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_clones"
    )
    {
        composable("lobby_clones") {
            LobbySocialMedias(
                navController,
                FeatureClonesNavigationImpl()
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