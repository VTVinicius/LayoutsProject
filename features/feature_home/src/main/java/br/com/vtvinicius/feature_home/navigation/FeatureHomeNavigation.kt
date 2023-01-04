package br.com.vtvinicius.feature_home.navigation

import androidx.navigation.NavController

interface FeatureHomeNavigation {

    fun goToFeatures(navController: NavController)
    fun goToFeatureViaCep(navController: NavController)
    fun goToFeatureClones(navController: NavController)
    fun goToFeatureCanvas(navController: NavController)
    fun goToFeatureGames(navController: NavController)
    fun goToFeatureUikit(navController: NavController)

}