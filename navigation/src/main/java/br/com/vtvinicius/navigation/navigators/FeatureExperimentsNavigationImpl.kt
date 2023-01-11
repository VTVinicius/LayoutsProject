package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_experiments.FeatureExperimentsNavigation

class FeatureExperimentsNavigationImpl : FeatureExperimentsNavigation {
    override fun goToLobby(navController: NavController) {
        navController.navigate("lobby_experiments")
    }

    override fun goToHomeFeature(navController: NavController) {
        navController.navigate("lobby_screen")
    }

    override fun goToMotionTopBar(navController: NavController) {
        navController.navigate("motion_top_bar")
    }

    override fun goToMotionButtons(navController: NavController) {
        navController.navigate("motion_button")
    }

    override fun goToBottomSheet1(navController: NavController) {
        navController.navigate("bottom_sheet_1")
    }

    override fun goToSideModal1(navController: NavController) {
        navController.navigate("side_modal_1")
    }

    override fun goToDialogs1(navController: NavController) {
        navController.navigate("dialogs_1")
    }
}