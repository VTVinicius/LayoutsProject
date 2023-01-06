package br.com.vtvinicius.feature_uikit

import androidx.navigation.NavController

interface FeatureUikitNavigation {

    fun goToLobbyUikit(navController: NavController)
    fun goToInputText(navController: NavController)

    fun goBackToHome(navController: NavController)
}