package br.com.vtvinicius.base_feature.lobby

import androidx.navigation.NavController

interface EntryPointNavigation {

    fun goToFeatureViaCep(navController: NavController)
    fun goToFeatureClones(navController: NavController)
    fun goToFeatureCanvas(navController: NavController)

}