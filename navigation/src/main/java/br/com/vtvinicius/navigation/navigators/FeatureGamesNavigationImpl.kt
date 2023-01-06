package br.com.vtvinicius.navigation.navigators

import androidx.navigation.NavController
import br.com.vtvinicius.feature_games.navigation.FeatureGamesNavigation

class FeatureGamesNavigationImpl : FeatureGamesNavigation {

    override fun goToHome(navController: NavController) {
        navController.navigate("lobby_screen")
    }

    override fun goToLobbyGames(navController: NavController) {
        navController.navigate("lobby_games")
    }

    override fun goToBallClickerGame(navController: NavController) {
        navController.navigate("ball_clicker_game")
    }

    override fun goBackToHome(navController: NavController) {
       navController.navigate("lobby_screen")
    }

    override fun goToTicTacToe(navController: NavController) {
        navController.navigate("tic_tac_toe")
    }


    override fun goToSnake(navController: NavController) {
        navController.navigate("snake")
    }


}