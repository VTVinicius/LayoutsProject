package br.com.vtvinicius.feature_example.navigation

import androidx.navigation.NavController

interface FeatureExampleNavigation {

    fun goToSecondScreen(navController: NavController)

    fun goToHomeScreen(navController: NavController)

    fun goBackToEntryPoint(navController: NavController)

    fun goToCepScreen(navController: NavController)

    fun goToHistoryScreen(navController: NavController)

    fun popBackStack(navController: NavController)
}