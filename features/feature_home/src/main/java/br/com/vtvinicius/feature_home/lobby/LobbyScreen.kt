package br.com.vtvinicius.feature_home.lobby

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.text.TitleMediumText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


@Composable
fun LobbyScreen(
    navController: NavController,
    navigation: FeatureHomeNavigation,
) {

    AppScaffold(
        topBar = { AppTopBar(title = "Lobby", hasBackButton = false) },
        content = {
            BackHandler() {
                // FAZ O BOTÃO DE VOLTAR NÃO FECHAR O APP
            }

            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                TitleMediumText(text = "Este é o Lobby, ponto que faz a navegação entre as Features")

                VerticalSpacer(56)

                AppButton(
                    onClick = { navigation.goToFeatureViaCep(navController) },
                    text = "Go to Feature Example"
                )

                AppButton(
                    onClick = { navigation.goToFeatureClones(navController) },
                    text = "Go to Feature Clones"
                )
                AppButton(
                    onClick = { navigation.goToFeatureCanvas(navController) },
                    text = "Go to Feature of Canvas"
                )
            }

        }
    )


}