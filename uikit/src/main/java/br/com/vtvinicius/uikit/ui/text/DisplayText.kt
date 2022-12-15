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
fun DisplayLargeText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.displayLarge.fontWeight,
    fontFamily: FontFamily? = typography.displayLarge.fontFamily,
    maxLines: Int = 10
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.displayLarge.fontSize,
        fontWeight = fontWeight,
        maxLines = maxLines
    )
}


@Composable
fun DisplayMediumText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.displayMedium.fontWeight,
    fontFamily: FontFamily? = typography.displayMedium.fontFamily,
    maxLines: Int = 10
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.displayMedium.fontSize,
        fontWeight = fontWeight,
        maxLines = maxLines
    )
}


@Composable
fun DisplaySmallText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.displaySmall.fontWeight,
    fontFamily: FontFamily? = typography.displaySmall.fontFamily,
    maxLines: Int = 10
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.displaySmall.fontSize,
        fontWeight = fontWeight,
        maxLines = maxLines
    )
}


