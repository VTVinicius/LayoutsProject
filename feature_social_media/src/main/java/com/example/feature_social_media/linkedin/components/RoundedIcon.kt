package com.example.feature_social_media.linkedin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RoundedIcon(
    modifier: Modifier = Modifier,
    icon: Int,
    boxSize: Dp = 35.dp,
    buttonColors: Color,
    iconColor: Color = Color.Black
) {

    Box(
        modifier
            .clip(CircleShape)
            .size(boxSize)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = CircleShape
            )

            .background(buttonColors)

    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Icon",
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Transparent),
            tint = iconColor
        )
    }
}


