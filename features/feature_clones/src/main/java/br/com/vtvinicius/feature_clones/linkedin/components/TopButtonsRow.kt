package br.com.vtvinicius.feature_clones.linkedin.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
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

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {


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
                textColor = Color.Gray,
                modifier = Modifier.weight(5f),
                text = "Adicionar \n seção"
            )
            HorizontalSpacer(width = 4)
            CircularButtons(
                onClick = { /*TODO*/ },
                buttonColor = Color.White,
                modifier = Modifier.weight(1f),
                icon = R.drawable.ic_three_dots,
            )
            HorizontalSpacer(width = 8)

        }
    }

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RoundedButtons(
    modifier: Modifier = Modifier,
    buttonColor: Color = Color.White,
    text: String = "",
    textColor: Color = Color.Black,
    icon: Int = 0,
    onClick: () -> Unit,
) {

    Card(
        onClick = { onClick },
        backgroundColor = buttonColor,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {

                BodyLargeText(
                    text = text,
                    maxLines = 2,
                    fontWeight = FontWeight.Bold,
                    colors = textColor
                )

            }
        },
        shape = RoundedCornerShape(90.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CircularButtons(
    modifier: Modifier = Modifier,
    buttonColor: Color = Color.White,
    text: String = "",
    textColor: Color = Color.Black,
    icon: Int = 0,
    onClick: () -> Unit,
) {

    Card(
        onClick = { onClick },
        backgroundColor = buttonColor,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {

                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
                )

            }
        },
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = modifier.size(35.dp)
    )
}