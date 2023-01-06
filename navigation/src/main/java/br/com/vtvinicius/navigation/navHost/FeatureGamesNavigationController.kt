package br.com.vtvinicius.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.feature_games.LobbyGames
import br.com.vtvinicius.feature_games.games.ball_clicker_game.BallClickerGameScreen
import br.com.vtvinicius.feature_games.games.sanke.SnakeGameScreen
import br.com.vtvinicius.feature_games.games.tic_tac_toe.TicTacToeScreen
import br.com.vtvinicius.navigation.navigators.FeatureGamesNavigationImpl


@Composable
fun FeatureGamesNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_games"
    ) {
        composable("lobby_games") {
            LobbyGames(navController, FeatureGamesNavigationImpl())
        }
        composable("ball_clicker_game") {
            BallClickerGameScreen()
        }
        composable("tic_tac_toe") {
            TicTacToeScreen()
        }
        composable("snake") {
            SnakeGameScreen()
        }
        composable("lobby_screen") {
            FeatureHomeNavigationController()
        }
    }
}