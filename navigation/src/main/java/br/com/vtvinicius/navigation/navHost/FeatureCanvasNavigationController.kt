package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.feature_canvas.LobbyCanvas
import br.com.vtvinicius.feature_canvas.animated_path.EffectPath
import br.com.vtvinicius.feature_canvas.clock.ClockScreen
import br.com.vtvinicius.feature_canvas.curve_lines.ExamplePath
import br.com.vtvinicius.feature_canvas.games.ball_clicker_game.BallClickerGameScreen
import br.com.vtvinicius.feature_canvas.games.sanke.SnakeGameScreen
import br.com.vtvinicius.feature_canvas.games.tic_tac_toe.TicTacToeScreen
import br.com.vtvinicius.feature_canvas.gender_picker.GenderScreen
import br.com.vtvinicius.feature_canvas.graphs.line_graph.LineGraphScreen
import br.com.vtvinicius.feature_canvas.weight_picker.WeightPickerScreen
import br.com.vtvinicius.navigation.navigators.FeatureCanvasNavigationImpl


@Composable
fun FeatureCanvasNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_canvas"
    ) {
        composable("lobby_canvas") {
            LobbyCanvas(navController, FeatureCanvasNavigationImpl())
        }
        composable("ball_clicker_game") {
            BallClickerGameScreen()
        }

        composable("weight_picker") {
            WeightPickerScreen()
        }
        composable("clock_screen") {
            ClockScreen()
        }

        composable("example_path") {
            ExamplePath()
        }

        composable("effect_path") {
            EffectPath()
        }
        composable("gender_picker_screen") {
            GenderScreen()
        }
        composable("tic_tac_toe") {
            TicTacToeScreen()
        }
        composable("line_graph") {
            LineGraphScreen()
        }
        composable("snake") {
            SnakeGameScreen()
        }
        composable("games") {
            SnakeGameScreen()
        }
    }
}