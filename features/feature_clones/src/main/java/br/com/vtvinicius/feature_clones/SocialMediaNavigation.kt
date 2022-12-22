package br.com.vtvinicius.feature_clones

import androidx.navigation.NavController

interface SocialMediaNavigation {

    fun goToInstagram(navController: NavController)
    fun goToLinkedin(navController: NavController)
    fun goToLobby(navController: NavController)

}