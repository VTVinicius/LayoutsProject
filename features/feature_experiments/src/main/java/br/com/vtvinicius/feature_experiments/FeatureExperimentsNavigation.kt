package br.com.vtvinicius.feature_experiments

import androidx.navigation.NavController

interface FeatureExperimentsNavigation {

    fun goToLobby(navController: NavController)

    fun goToHomeFeature(navController: NavController)

    fun goToMotionTopBar(navController: NavController)

    fun goToMotionButtons(navController: NavController)

    fun goToBottomSheet1(navController: NavController)

    fun goToSideModal1(navController: NavController)

    fun goToDialogs1(navController: NavController)

    fun goToRadioButtonsScreen(navController: NavController)

    fun goToCheckBoxesScreen(navController: NavController)
}