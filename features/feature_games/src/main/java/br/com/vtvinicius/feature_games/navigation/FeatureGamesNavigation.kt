package br.com.vtvinicius.feature_games.navigation

import androidx.navigation.NavController

interface FeatureGamesNavigation {

    fun goToHome(navController: NavController)

    fun goToLobbyGames(navController: NavController)

    fun goToTicTacToe(navController: NavController)

    fun goToSnake(navController: NavController)

    fun goToBallClickerGame(navController: NavController)
}