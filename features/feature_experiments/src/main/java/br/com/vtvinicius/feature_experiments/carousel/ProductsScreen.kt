package br.com.vtvinicius.feature_experiments.carousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.feature_experiments.FeatureExperimentsNavigation
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.greenExperimentsDark
import br.com.vtvinicius.uikit.base.greenExperimentsLight
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@Composable
fun ProductsPagerScreen(navigation: FeatureExperimentsNavigation, navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Products Pager",
                onBackPressed = { navigation.goToLobby(navController) },
                backgroundColor = greenExperimentsLight,
                textColor = greenExperimentsDark
            )
        },
        content = {

            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ProductsPager()
            }
        })

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductsPager() {

    val itemsCarousel = listOf(
        R.drawable.img_vini_1,
        R.drawable.img_vini_2,
        R.drawable.img_vini_3,
        R.drawable.img_vini_4,
    )

    Column {

        val pagerState = rememberPagerState()

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

            HorizontalPager(count = itemsCarousel.size, state = pagerState) { page ->
                Image(
                    painter = painterResource(id = itemsCarousel[page]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .border(
                            width = 1.dp,
                            color = Color.White
                        )
                )
            }
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .padding(16.dp),
            )
        }
    }
}
