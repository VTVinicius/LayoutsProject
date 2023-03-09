package br.com.vtvinicius.feature_canvas.star

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.gold
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer




@Composable
fun StarsIcons() {



    var color1 by remember { mutableStateOf(Color.LightGray) }
    var targetColor1 = gold

    var color2 by remember { mutableStateOf(Color.LightGray) }
    var targetColor2 = gold

    var color3 by remember { mutableStateOf(Color.LightGray) }
    var targetColor3 = gold

    var color4 by remember { mutableStateOf(Color.LightGray) }
    var targetColor4 = gold

    var color5 by remember { mutableStateOf(Color.LightGray) }
    var targetColor5 = gold


    val animeteColorAsState = animateColorAsState(
        targetValue = targetColor1,
        animationSpec = tween(durationMillis = 5000)
    )

    val animeteColorAsState2 = animateColorAsState(
        targetValue = Color.LightGray,
        animationSpec = tween(durationMillis = 5000)
    )
    val animeteColorAsState3 = animateColorAsState(
        targetValue = targetColor2,
        animationSpec = tween(durationMillis = 5000)
    )

    val animeteColorAsState4 = animateColorAsState(
        targetValue = Color.LightGray,
        animationSpec = tween(durationMillis = 5000)
    )
    val animeteColorAsState5 = animateColorAsState(
        targetValue = targetColor3,
        animationSpec = tween(durationMillis = 5000)
    )

    val animeteColorAsState6 = animateColorAsState(
        targetValue = Color.LightGray,
        animationSpec = tween(durationMillis = 5000)
    )
    val animeteColorAsState7 = animateColorAsState(
        targetValue = targetColor3,
        animationSpec = tween(durationMillis = 5000)
    )

    val animeteColorAsState8 = animateColorAsState(
        targetValue = Color.LightGray,
        animationSpec = tween(durationMillis = 5000)
    )
    val animeteColorAsState9 = animateColorAsState(
        targetValue = targetColor3,
        animationSpec = tween(durationMillis = 5000)
    )

    val animeteColorAsState10 = animateColorAsState(
        targetValue = Color.LightGray,
        animationSpec = tween(durationMillis = 5000)
    )

    var selectedStar by remember {
        mutableStateOf<Stars>(Stars.Star0)
    }

    targetColor1 =
        if (selectedStar is Stars.Star1 || selectedStar is Stars.Star2 || selectedStar is Stars.Star3 || selectedStar is Stars.Star4 || selectedStar is Stars.Star5) animeteColorAsState.value else animeteColorAsState.value
    targetColor2 =
        if (selectedStar is Stars.Star2 || selectedStar is Stars.Star3 || selectedStar is Stars.Star4 || selectedStar is Stars.Star5) animeteColorAsState3.value else animeteColorAsState4.value
    targetColor3 =
        if (selectedStar is Stars.Star5 || selectedStar is Stars.Star4 || selectedStar is Stars.Star3) animeteColorAsState5.value else animeteColorAsState6.value
    targetColor4 =
        if (selectedStar is Stars.Star4 || selectedStar is Stars.Star5) animeteColorAsState7.value else animeteColorAsState8.value
    targetColor5 =
        if (selectedStar is Stars.Star5) animeteColorAsState9.value else animeteColorAsState10.value


    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

        Icon(
            Icons.Default.Star,
            contentDescription = "Animated Icon",
            tint = targetColor1,
            modifier = Modifier.size(35.dp).clickable {
                selectedStar = Stars.Star1
            }
        )
        HorizontalSpacer(width = 8)
        Icon(
            Icons.Default.Star,
            contentDescription = "Animated Icon",
            tint = targetColor2,
            modifier = Modifier.size(35.dp).clickable {
                selectedStar = Stars.Star2
            }
        )
        HorizontalSpacer(width = 8)
        Icon(
            Icons.Default.Star,
            contentDescription = "Animated Icon",
            tint = targetColor3,
            modifier = Modifier.size(35.dp).clickable {
                selectedStar = Stars.Star3

            }
        )
        HorizontalSpacer(width = 8)
        Icon(
            Icons.Default.Star,
            contentDescription = "Animated Icon",
            tint = targetColor4,
            modifier = Modifier.size(35.dp).clickable {
                selectedStar = Stars.Star4
            }
        )
        HorizontalSpacer(width = 8)
        Icon(
            Icons.Default.Star,
            contentDescription = "Animated Icon",
            tint = targetColor5,
            modifier = Modifier.size(35.dp).clickable {
                selectedStar = Stars.Star5
            }
        )
    }
}