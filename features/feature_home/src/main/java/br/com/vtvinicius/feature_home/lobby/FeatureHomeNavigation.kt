package br.com.vtvinicius.feature_home.lobby

import androidx.navigation.NavController

interface FeatureHomeNavigation {

    fun goToFeatureViaCep(navController: NavController)
    fun goToFeatureClones(navController: NavController)
    fun goToFeatureCanvas(navController: NavController)

}