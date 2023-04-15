package br.com.vtvinicius.feature_games

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_games.navigation.FeatureGamesNavigation
import br.com.vtvinicius.uikit.base.background
import br.com.vtvinicius.uikit.base.yellowGamesDark
import br.com.vtvinicius.uikit.base.yellowGamesLight
import br.com.vtvinicius.uikit.ui.button.FeaturesButton
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun LobbyGames(
    navController: NavController,
    navigation: FeatureGamesNavigation,
) {

    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Jogos", onBackPressed = { navigation.goBackToHome(navController) },
                textColor = yellowGamesDark, backgroundColor = yellowGamesLight
            )
        },
        content = {

            Column(
                Modifier
                    .fillMaxSize()
                    .background(background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                VerticalSpacer(height = 24)

                FeaturesButton(
                    backgroundColor = yellowGamesLight,
                    textColor = yellowGamesDark,
                    onClick = { navigation.goToBallClickerGame(navController) },
                    text = "Ball Clicker Game"
                )

                VerticalSpacer(height = 24)

                FeaturesButton(
                    backgroundColor = yellowGamesLight,
                    textColor = yellowGamesDark,
                    onClick = { navigation.goToTicTacToe(navController) },
                    text = "Tic Tac Toe"
                )

                VerticalSpacer(height = 24)

                FeaturesButton(
                    backgroundColor = yellowGamesLight,
                    textColor = yellowGamesDark,
                    onClick = { navigation.goToSnake(navController) },
                    text = "Snake"
                )

                VerticalSpacer(height = 24)


            }

        }
    )
}

