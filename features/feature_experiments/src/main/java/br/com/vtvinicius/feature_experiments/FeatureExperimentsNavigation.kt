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

    fun goToProductsPagerScreen(navController: NavController)

    fun goToCarouselScreen(navController: NavController)

    fun goToRangeSliderScreen(navController: NavController)

    fun goToShimmerScreen(navController: NavController)

    fun goToSwitchButtons(navController: NavController)

    fun goToDropDownScreen(navController: NavController)
}