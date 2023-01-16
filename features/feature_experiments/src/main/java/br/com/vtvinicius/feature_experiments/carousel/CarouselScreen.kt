package br.com.vtvinicius.feature_experiments.carousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import br.com.vtvinicius.uikit.ui.text.TitleLargeText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@Composable
fun CarouselScreen(navigation: FeatureExperimentsNavigation, navController: NavController) {

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Carousel",
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

        TitleLargeText(text = "Carrossel Animado ainda não funciona direito")
        VerticalSpacer(height = 16)
        Carousel(true)
        VerticalSpacer(height = 50)
        TitleLargeText(text = "Carrossel sem animação funciona direito")
        VerticalSpacer(height = 16)
        Carousel(false)
        }})
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Carousel(animated: Boolean = false) {
    val itemsCarousel = listOf(
        R.drawable.img_vini_1,
        R.drawable.img_vini_2,
        R.drawable.img_vini_3,
        R.drawable.img_vini_4,
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
                    painter = painterResource(id = itemsCarousel[pagerState.currentPage]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp, 100.dp)
                        .border(
                            width = 1.dp,
                            color = Color.White
                        )
                )
            }
        }

        if (animated) {
            //dalay to incress progress
            LaunchedEffect(key1 = pagerState.currentPage) {
                delay(3000)
                if (pagerState.currentPage < pagerState.pageCount - 1) {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                } else {
                    pagerState.animateScrollToPage(pagerState.currentPage - pagerState.currentPage)
                }
            }
        } else {
            LaunchedEffect(key1 = pagerState.currentPage) {
                delay(3000)
                if (pagerState.currentPage < pagerState.pageCount - 1) {
                    pagerState.scrollToPage(pagerState.currentPage + 1)
                } else {
                    pagerState.scrollToPage(pagerState.currentPage - pagerState.currentPage)
                }
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