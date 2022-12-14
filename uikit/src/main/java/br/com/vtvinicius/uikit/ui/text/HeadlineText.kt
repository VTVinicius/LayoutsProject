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
fun HeadlineLargeText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.headlineLarge.fontWeight,
    fontFamily: FontFamily? = typography.headlineLarge.fontFamily,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.headlineLarge.fontSize,
        fontWeight = fontWeight
    )
}

@Composable
fun HeadlineMediumText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.headlineMedium.fontWeight,
    fontFamily: FontFamily? = typography.headlineMedium.fontFamily,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.headlineMedium.fontSize,
        fontWeight = fontWeight
    )
}

@Composable
fun HeadlineSmallText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.headlineSmall.fontWeight,
    fontFamily: FontFamily? = typography.headlineSmall.fontFamily,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.headlineSmall.fontSize,
        fontWeight = fontWeight
    )
}
