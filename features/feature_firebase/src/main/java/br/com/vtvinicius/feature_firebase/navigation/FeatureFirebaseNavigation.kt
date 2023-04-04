package br.com.vtvinicius.feature_firebase.navigation

import androidx.navigation.NavController

interface FeatureFirebaseNavigation {

    fun goToLoginScreen(navController: NavController)

    fun goToRegisterScreen(navController: NavController)

    fun goToLoggedScreen(navController: NavController)

}