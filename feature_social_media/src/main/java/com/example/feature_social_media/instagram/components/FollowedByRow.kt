package com.example.feature_social_media.instagram.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.ui.text.LabelSmallText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer

@Composable
fun FallowedByRow() {

    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        RoundImageSmall(
            image = painterResource(id = R.drawable.profile_pic),
            modifier = Modifier
                .size(30.dp)
                .offset(x = 30.dp)
        )
        RoundImageSmall(
            image = painterResource(id = R.drawable.profile_pic),
            modifier = Modifier
                .size(30.dp)
                .offset(x = (-15).dp)
        )

        HorizontalSpacer(width = 8)
        LabelSmallText(text = "Seguido(a) por vine_2308, _anamichel e outras 114 pessoas")
    }


}


@Composable
fun RoundImageSmall(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = false)
            .border(
                width = 1.dp,
                color = Color.White,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)


    )
}