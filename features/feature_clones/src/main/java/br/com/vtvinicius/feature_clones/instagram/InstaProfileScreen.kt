package br.com.vtvinicius.feature_clones.instagram

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.feature_clones.instagram.components.*
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun InstaProfileScreen() {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    AppScaffold(
        topBar = {
            InstaTopBar(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )
        },
        content = {

            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()) {
                ProfileStats()
                DescriptionComponent()
                FallowedByRow()
                VerticalSpacer(height = 16)
                ButtonsMiddleRow()
                DestaquesRow()
                PostTabView(
                imageWithTexts = listOf(
                    ImageWithText(
                        image = painterResource(id = br.com.vtvinicius.uikit.R.drawable.ic_grid),
                        text = "Posts"
                    ),
                    ImageWithText(
                        image = painterResource(id =  br.com.vtvinicius.uikit.R.drawable.ic_reels),
                        text = "Reels"
                    ),
                    ImageWithText(
                        image = painterResource(id =  br.com.vtvinicius.uikit.R.drawable.ic_tag),
                        text = "Profile"
                    ),
                )) {
                    selectedTabIndex = it
                }

                when(selectedTabIndex) {
                    0 -> PostSection(
                        posts = listOf(
                            painterResource(id = br.com.vtvinicius.uikit.R.drawable.img_vini_1),
                            painterResource(id = br.com.vtvinicius.uikit.R.drawable.img_vini_2),
                            painterResource(id = br.com.vtvinicius.uikit.R.drawable.img_vini_3),
                            painterResource(id = br.com.vtvinicius.uikit.R.drawable.img_vini_4),
                            painterResource(id = br.com.vtvinicius.uikit.R.drawable.img_vini_5),
                            painterResource(id = br.com.vtvinicius.uikit.R.drawable.img_vini_1),
                            painterResource(id = br.com.vtvinicius.uikit.R.drawable.img_vini_2),
                            painterResource(id = br.com.vtvinicius.uikit.R.drawable.img_vini_3),
                            painterResource(id = br.com.vtvinicius.uikit.R.drawable.img_vini_4),
                            painterResource(id = br.com.vtvinicius.uikit.R.drawable.img_vini_5),
                        ),
                        modifier = Modifier.height(600.dp)
                    )
                }
            }

        })
}

