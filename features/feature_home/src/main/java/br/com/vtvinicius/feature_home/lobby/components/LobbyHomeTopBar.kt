package br.com.vtvinicius.feature_home.lobby.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.greenApp
import br.com.vtvinicius.uikit.ui.image.RoundedImage
import br.com.vtvinicius.uikit.ui.text.TitleLargeText
import br.com.vtvinicius.uikit.ui.text.TitleSmallText
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


@Composable
fun LobbyHomeTopBar() {
    Card(modifier = Modifier.offset(y = (-10).dp), shape = RoundedCornerShape(16.dp), elevation = 8.dp, backgroundColor = greenApp) {

        Column(
            Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            VerticalSpacer(height = 48)

            Row(verticalAlignment = Alignment.CenterVertically) {
                RoundedImage(
                    image = painterResource(id = R.drawable.profile_pic),
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )

            }

            VerticalSpacer(height = 5)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                TitleLargeText(text = "Vinicius Teixeira", colors = Color.White)

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                TitleSmallText(text = "Desenvolvedor Android", colors = Color.White)

            }
            VerticalSpacer(height = 32)
        }
    }
}

