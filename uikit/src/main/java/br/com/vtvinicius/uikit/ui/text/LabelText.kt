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
fun LabelLargeText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.labelLarge.fontWeight,
    fontFamily: FontFamily? = typography.labelLarge.fontFamily,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.labelLarge.fontSize,
        fontWeight = fontWeight
    )
}

@Composable
fun LabelMediumText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.labelMedium.fontWeight,
    fontFamily: FontFamily? = typography.labelMedium.fontFamily,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.labelMedium.fontSize,
        fontWeight = fontWeight
    )
}

@Composable
fun LabelSmallText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.labelSmall.fontWeight,
    fontFamily: FontFamily? = typography.labelSmall.fontFamily,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.labelSmall.fontSize,
        fontWeight = fontWeight
    )
}