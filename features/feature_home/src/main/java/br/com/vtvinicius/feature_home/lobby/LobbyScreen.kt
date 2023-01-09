package br.com.vtvinicius.feature_home.lobby

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_home.lobby.components.ButtonApplications
import br.com.vtvinicius.feature_home.lobby.components.LobbyHomeTopBar
import br.com.vtvinicius.feature_home.navigation.FeatureHomeNavigation
import br.com.vtvinicius.uikit.base.*
import br.com.vtvinicius.uikit.ui.text.TitleLargeText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


@Composable
fun LobbyScreen(
    navController: NavController,
    navigation: FeatureHomeNavigation,
) {

    AppScaffold(
        content = {
            BackHandler() {
                // FAZ O BOTÃO DE VOLTAR NÃO FECHAR O APP
            }

            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(background),
            ) {
                LobbyHomeTopBar()

                VerticalSpacer(height = 24)

                TitleLargeText(
                    text = "Projetos",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                VerticalSpacer(height = 24)


                CarrouselApps()

                VerticalSpacer(32)


                TitleLargeText(
                    text = "Aplicações",
                    colors = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )


                VerticalSpacer(height = 24)

                ButtonsColumn(navController, navigation)


                VerticalSpacer(height = 32)

            }

        }
    )

}


@Composable
fun ButtonsColumn(navController: NavController, navigation: FeatureHomeNavigation) {

    ButtonApplications(
        textColor = greenFeaturesDark,
        backgroundColor = greenFeatures,
        text = "Features",
        onClick = {
            navigation.goToFeatures(navController)
        },
        image = br.com.vtvinicius.uikit.R.drawable.img_features
    )


    VerticalSpacer(height = 20)

    ButtonApplications(
        textColor = blueCanvasDark,
        backgroundColor = blueCanvasLight,
        text = "Canvas",
        onClick = {
            navigation.goToFeatureCanvas(navController)
        },
        image = br.com.vtvinicius.uikit.R.drawable.img_canvas
    )

    VerticalSpacer(height = 20)

    ButtonApplications(
        textColor = yellowGamesDark,
        backgroundColor = yellowGamesLight,
        text = "Jogos",
        onClick = {
            navigation.goToFeatureGames(navController)
        },
        image = br.com.vtvinicius.uikit.R.drawable.img_games
    )

    VerticalSpacer(height = 20)

    ButtonApplications(
        textColor = redClonesDark,
        backgroundColor = redClonesLight,
        text = "Clones",
        onClick = {
            navigation.goToFeatureClones(navController)
        },
        image = br.com.vtvinicius.uikit.R.drawable.img_clones
    )

    VerticalSpacer(height = 20)

    ButtonApplications(
        textColor = purpleUikitDark,
        backgroundColor = purpleUikitLight,
        text = "Uikit",
        onClick = {
            navigation.goToFeatureUikit(navController)
        },
        image = br.com.vtvinicius.uikit.R.drawable.img_uikit
    )

}

@Composable
fun CarrouselApps() {

    val lazySate = rememberLazyListState()

    LazyRow(content = {
        items(1) {

            HorizontalSpacer(width = 24)

            ItemsCarrousel(
                backgroundColor = Color.Transparent,
                image = br.com.vtvinicius.uikit.R.drawable.img_havan
            ) {
            }

            HorizontalSpacer(width = 16)

            ItemsCarrousel(
                backgroundColor = yellowRiHappy,
                image = br.com.vtvinicius.uikit.R.drawable.img_logo_rihappy
            ) {
            }

            HorizontalSpacer(width = 16)

            ItemsCarrousel(
                backgroundColor = orangeLeve,
                image = br.com.vtvinicius.uikit.R.drawable.img_logo_leve
            ) {
            }

            HorizontalSpacer(width = 24)
        }
    }, state = lazySate)

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemsCarrousel(
    backgroundColor: Color,
    image: Int,
    onClick: () -> Unit,
) {

    Card(
        backgroundColor = backgroundColor,
        onClick = onClick,
        modifier = Modifier
            .height(100.dp)
            .width(130.dp),
        shape = RoundedCornerShape(6.dp)
    ) {

        Image(painter = painterResource(id = image), contentDescription = "Image")

    }

}