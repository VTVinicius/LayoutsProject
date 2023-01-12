package br.com.vtvinicius.uikit.ui.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CircularIconButton(
    modifier: Modifier = Modifier,
    buttonColor: Color = Color.White,
    iconSize: Int = 15,
    size: Int = 35,
    icon: Int = 0,
    borderColor: Color = Color.LightGray,
    borderSize: Int = 1,
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
                    modifier = Modifier.size(iconSize.dp)
                )

            }
        },
        shape = CircleShape,
        border = BorderStroke(borderSize.dp, borderColor),
        modifier = modifier.size(size.dp)
    )
}