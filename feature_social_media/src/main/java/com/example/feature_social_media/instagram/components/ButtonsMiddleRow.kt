package com.example.feature_social_media.instagram.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.base.lightGray
import br.com.vtvinicius.uikit.ui.text.TitleSmallText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer

@Composable
fun ButtonsMiddleRow() {


    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {


        GrayButton(
            {},
            text = "Seguindo",
            modifier = Modifier.weight(5f),
            icon = br.com.vtvinicius.uikit.R.drawable.ic_arrow_dropdown,
            iconSize = 10.dp,
            iconPadding = 5
        )

        HorizontalSpacer(width = 8)

        GrayButton({}, text = "Mensagem", modifier = Modifier.weight(5f))

        HorizontalSpacer(width = 8)

        GrayButton({}, icon = br.com.vtvinicius.uikit.R.drawable.ic_add_user)

    }


}


@Composable
fun GrayButton(
    onClick: () -> Unit,
    text: String? = "",
    modifier: Modifier = Modifier,
    icon: Int? = null,
    textColor: Color = Color.Black,
    iconSize: Dp = 20.dp,
    iconPadding: Int = 0
) {


    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = lightGray),
        shape = RoundedCornerShape(16),
        modifier = modifier.height(34.dp)
    ) {
        if (text != null) {
            TitleSmallText(
                text = text,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(y = (-2).dp),
                colors = textColor
            )
        }

        if (icon != null) {

            HorizontalSpacer(width = iconPadding)

            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(iconSize)
            )
        }
    }


}