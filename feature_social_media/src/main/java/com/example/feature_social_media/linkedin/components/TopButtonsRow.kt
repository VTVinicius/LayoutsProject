package com.example.feature_social_media.linkedin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.ui.text.BodyLargeText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun TopButtonsRow() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_plus),
                contentDescription = "Plus",
                tint = Color.Blue,
                modifier = Modifier.size(10.dp)
            )
            HorizontalSpacer(width = 4)
            BodyLargeText(
                text = "de 500 conexões",
                colors = Color.Blue,
                fontWeight = FontWeight.Normal
            )


        }


        VerticalSpacer(height = 16)

        Row(Modifier.fillMaxWidth()) {


            HorizontalSpacer(width = 8)
            RoundedButtons(
                onClick = { /*TODO*/ }, modifier = Modifier.weight(5f),
                buttonColor = Color.Blue,
                text = "Tenho \n interesse em...",
                textColor = Color.White
            )
            HorizontalSpacer(width = 4)
            RoundedButtons(
                onClick = { /*TODO*/ },
                buttonColor = Color.White,
                modifier = Modifier.weight(5f),
                text = "Adicionar \n seção"
            )
            HorizontalSpacer(width = 4)
            RoundedButtons(
                onClick = { /*TODO*/ },
                buttonColor = Color.White,
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_plus
            )
            HorizontalSpacer(width = 8)

        }
    }


}


@Composable
fun RoundedButtons(
    modifier: Modifier = Modifier,
    buttonColor: Color = Color.White,
    text: String = "",
    textColor: Color = Color.Black,
    icon: Int = 0,
    onClick: () -> Unit
) {

    Button(
        onClick = { onClick },
        modifier = modifier
            .background(shape = CircleShape, color = buttonColor)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = CircleShape
            ),
        colors = ButtonDefaults.buttonColors(buttonColor),
        shape = CircleShape,

        )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            if (text.isBlank()) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Plus",
                    tint = Color.Blue,
                    modifier = Modifier.size(10.dp)
                )
            } else {
                BodyLargeText(
                    text = text,
                    maxLines = 2,
                    fontWeight = FontWeight.Bold,
                    colors = textColor
                )

            }
        }
    }
}