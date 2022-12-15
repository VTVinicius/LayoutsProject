package com.example.feature_social_media.instagram.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.ui.text.TitleLargeText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer

@Composable
fun InstaTopBar(modifier: Modifier = Modifier, name: String = "vine_2308") {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        HorizontalSpacer(width = 16)
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        HorizontalSpacer(width = 32)

        TitleLargeText(text = name, fontWeight = FontWeight.Bold)

        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = "Bell",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )

            HorizontalSpacer(width = 16)

            Icon(
                painter = painterResource(id = R.drawable.ic_dots_menu),
                contentDescription = "Dots Menu",
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
            )
            HorizontalSpacer(width = 24)
        }

    }


}