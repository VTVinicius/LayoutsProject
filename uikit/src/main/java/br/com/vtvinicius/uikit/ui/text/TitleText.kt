package br.com.vtvinicius.uikit.ui.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import br.com.vtvinicius.uikit.base.ApplicationTheme.typography


@Composable
fun TitleLargeText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    fontWeight: FontWeight? = typography.titleLarge.fontWeight,
    fontFamily: FontFamily? = typography.titleLarge.fontFamily,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.titleLarge.fontSize,
        fontWeight = fontWeight
    )
}

@Composable
fun TitleMediumText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    fontWeight: FontWeight? = typography.titleMedium.fontWeight,
    fontFamily: FontFamily? = typography.titleMedium.fontFamily,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.titleMedium.fontSize,
        fontWeight = fontWeight
    )
}

@Composable
fun TitleSmallText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    fontWeight: FontWeight? = typography.titleSmall.fontWeight,
    fontFamily: FontFamily? = typography.titleSmall.fontFamily,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.titleSmall.fontSize,
        fontWeight = fontWeight
    )
}

