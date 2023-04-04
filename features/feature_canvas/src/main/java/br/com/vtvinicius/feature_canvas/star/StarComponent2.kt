//package br.com.vtvinicius.feature_canvas.star
//
//import androidx.compose.animation.animateColorAsState
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.Icon
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import br.com.vtvinicius.uikit.R
//import br.com.vtvinicius.uikit.base.gold
//import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
//
//
//@Composable
//fun FiveStarsIcons(
//    modifier: Modifier = Modifier,
//    onStarSelected: (Stars) -> Unit,
//    distanceBetweenStars: Dp = 35.dp,
//    animStarTimeFill: Int = 300,
//    animStarTimeEmpty: Int = 200,
//    colorStarUnselected: Color = Color.LightGray,
//    icon1: Int = R.drawable.star_24,
//    icon2: Int = R.drawable.star_24,
//    icon3: Int = R.drawable.star_24,
//    icon4: Int = R.drawable.star_24,
//    icon5: Int = R.drawable.star_24,
//    icon1Color: Color = Color(0XFFffd700),
//    icon2Color: Color = Color(0XFFffd700),
//    icon3Color: Color = Color(0XFFffd700),
//    icon4Color: Color = Color(0XFFffd700),
//    icon5Color: Color = Color(0XFFffd700),
//    sizeIcons: Dp = 24.dp,
//    iconsAlignment: Arrangement.Horizontal = Arrangement.Absolute.Center,
//) {
//
//    var selectedStar by remember {
//        mutableStateOf<Stars>(Stars.Star0)
//    }
//
//    //Declara as variaveis que controlam qual estrela foi selecionada
//    var targetValue1 by remember {
//        mutableStateOf(icon1Color)
//    }
//    var targetValue2 by remember {
//        mutableStateOf(icon2Color)
//    }
//    var targetValue3 by remember {
//        mutableStateOf(icon3Color)
//    }
//    var targetValue4 by remember {
//        mutableStateOf(icon4Color)
//    }
//    var targetValue5 by remember {
//        mutableStateOf(icon5Color)
//    }
//
//    //Faz a validação de quais estrela tem que preencher quando clicada. No caso se a Quarta estrela foi selecionada, preenche todas para tras.
//    targetValue1 =
//        if (selectedStar is Stars.Star1 || selectedStar is Stars.Star2 || selectedStar is Stars.Star3 || selectedStar is Stars.Star4 || selectedStar is Stars.Star5) icon1Color else colorStarUnselected
//    targetValue2 =
//        if (selectedStar is Stars.Star2 || selectedStar is Stars.Star3 || selectedStar is Stars.Star4 || selectedStar is Stars.Star5) icon2Color else colorStarUnselected
//    targetValue3 =
//        if (selectedStar is Stars.Star5 || selectedStar is Stars.Star4 || selectedStar is Stars.Star3) icon3Color else colorStarUnselected
//    targetValue4 =
//        if (selectedStar is Stars.Star4 || selectedStar is Stars.Star5) icon4Color else colorStarUnselected
//    targetValue5 =
//        if (selectedStar is Stars.Star5) icon5Color else colorStarUnselected
//
//
//    //Controla as Animações de preenchimento e despreenchimento das estrelas.
//    //A animação para preenchimento por algum motivo é mais rapida que a de despreenchimento, então foi necessário fazer uma correção para que as animações fiquem Parecidas.
//    val star1SelectionRadius = animateColorAsState(
//        targetValue = targetValue1,
//        animationSpec = if (targetValue1 == icon1Color) tween(durationMillis = animStarTimeFill * 1) else tween(
//            durationMillis = (animStarTimeEmpty) * 5
//        )
//    )
//    val star2SelectionRadius = animateColorAsState(
//        targetValue = targetValue2,
//        animationSpec = if (targetValue2 == icon2Color)
//            tween(durationMillis = animStarTimeFill * 2)
//        else tween(
//            durationMillis = (animStarTimeEmpty / 2) * 4
//        )
//    )
//    val star3SelectionRadius = animateColorAsState(
//        targetValue = targetValue3,
//        animationSpec = if (targetValue3 == icon3Color) tween(durationMillis = animStarTimeFill * 3) else tween(
//            durationMillis = (animStarTimeEmpty / 2) * 3
//        )
//    )
//    val star4SelectionRadius = animateColorAsState(
//        targetValue = targetValue4,
//        animationSpec = if (targetValue4 == icon4Color) tween(durationMillis = animStarTimeFill * 4) else tween(
//            durationMillis = (animStarTimeEmpty) / 2 * 2
//        )
//    )
//    val star5SelectionRadius = animateColorAsState(
//        targetValue = targetValue5,
//        animationSpec = if (targetValue5 == icon5Color) tween(durationMillis = animStarTimeFill * 5) else tween(
//            durationMillis = (animStarTimeEmpty / 2) * 1
//        )
//    )
//
//
//    Row(
//        modifier = modifier.fillMaxWidth(),
//        horizontalArrangement = iconsAlignment,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//
//        Icon(
//            painterResource(id = icon1),
//            contentDescription = "Animated Icon",
//            tint = star1SelectionRadius.value,
//            modifier = Modifier
//                .size(sizeIcons)
//                .clickable {
//                    selectedStar = Stars.Star1
//                    onStarSelected(selectedStar)
//                }
//        )
//
//        Spacer(Modifier.width(distanceBetweenStars))
//
//        Icon(
//            painterResource(id = icon2),
//            contentDescription = "Animated Icon",
//            tint = star2SelectionRadius.value,
//            modifier = Modifier
//                .size(sizeIcons)
//                .clickable {
//                    selectedStar = Stars.Star2
//                    onStarSelected(selectedStar)
//                }
//        )
//        Spacer(Modifier.width(distanceBetweenStars))
//        Icon(
//            painterResource(id = icon3),
//            contentDescription = "Animated Icon",
//            tint = star3SelectionRadius.value,
//            modifier = Modifier
//                .size(sizeIcons)
//                .clickable {
//                    selectedStar = Stars.Star3
//                    onStarSelected(selectedStar)
//                }
//        )
//        Spacer(Modifier.width(distanceBetweenStars))
//        Icon(
//            painterResource(id = icon4),
//            contentDescription = "Animated Icon",
//            tint = star4SelectionRadius.value,
//            modifier = Modifier
//                .size(sizeIcons)
//                .clickable {
//                    selectedStar = Stars.Star4
//                    onStarSelected(selectedStar)
//                }
//        )
//        Spacer(Modifier.width(distanceBetweenStars))
//        Icon(
//            painterResource(id = icon5),
//            contentDescription = "Animated Icon",
//            tint = star5SelectionRadius.value,
//            modifier = Modifier
//                .size(sizeIcons)
//                .clickable {
//                    selectedStar = Stars.Star5
//                    onStarSelected(selectedStar)
//                }
//        )
//    }
//}
