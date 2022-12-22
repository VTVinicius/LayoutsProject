package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_canvas.FeatureCanvasNavigation

class FeatureCanvasNavigationImpl : FeatureCanvasNavigation {

    override fun goToLobbyCanvas(navController: NavController) {
        navController.navigate("lobby_canvas")
    }

    override fun goToBallClickerGame(navController: NavController) {
        navController.navigate("ball_clicker_game")
    }

    override fun goToWeightPicker(navController: NavController) {
        navController.navigate("weight_picker")
    }

    override fun goToClock(navController: NavController) {
        navController.navigate("clock_screen")
    }

    override fun goToExamplePath(navController: NavController) {
        navController.navigate("example_path")
    }

    override fun goToEffectPath(navController: NavController) {
        navController.navigate("effect_path")
    }

    override fun goToGenderPicker(navController: NavController) {
        navController.navigate("gender_picker_screen")
    }

    override fun goToTicTacToe(navController: NavController) {
        navController.navigate("tic_tac_toe")
    }

    override fun goToLineGraph(navController: NavController) {
        navController.navigate("line_graph")
    }

    override fun goToSnake(navController: NavController) {
        navController.navigate("snake")
    }
}