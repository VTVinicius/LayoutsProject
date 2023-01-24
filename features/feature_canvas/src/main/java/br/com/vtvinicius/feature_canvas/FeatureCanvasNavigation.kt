package br.com.vtvinicius.feature_canvas

import androidx.navigation.NavController

interface FeatureCanvasNavigation {

    fun goToLobbyCanvas(navController: NavController)

    fun goToWeightPicker(navController: NavController)

    fun goToClock(navController: NavController)

    fun goToExamplePath(navController: NavController)

    fun goToEffectPath(navController: NavController)

    fun goToGenderPicker(navController: NavController)

    fun goToLineGraph(navController: NavController)

    fun goBackToHome(navController: NavController)

    fun goToAnimatedArrows(navController: NavController)

}