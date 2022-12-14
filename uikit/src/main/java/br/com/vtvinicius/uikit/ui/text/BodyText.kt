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
fun BodyLargeText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.bodyLarge.fontWeight,
    fontFamily: FontFamily? = typography.bodyLarge.fontFamily,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.bodyLarge.fontSize,
        fontWeight = fontWeight
    )
}


@Composable
fun BodyMediumText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight? = typography.bodyMedium.fontWeight,
    fontFamily: FontFamily? = typography.bodyMedium.fontFamily,
) {
    Text(
        modifier = modifier,
        textAlign = align,
        text = text,
        style = TextStyle(
            fontFamily = fontFamily,
            color = colors
        ),
        fontSize = typography.bodyMedium.fontSize,
        fontWeight = fontWeight
    )
}

@Composable
fun BodySmallText(
    text: String,
    colors: Color = Color.Black,
    align: TextAlign = TextAlign.Center,
    fontWeight: FontWeight? = typography.bodySmall.fontWeight,
    fontFamily: FontFamily? = typography.bodySmall.fontFamily,
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
        fontSize = typography.bodySmall.fontSize,
        fontWeight = fontWeight
    )
}
