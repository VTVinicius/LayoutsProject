package br.com.vtvinicius.uikit.ui.topbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.greenApp
import br.com.vtvinicius.uikit.ui.text.HeadlineSmallText


@Preview
@Composable
fun Preview() {
    AppTopBar(
        title = "Histórico",
        onBackPressed = {}
    )
}

@Composable
fun AppTopBar(
    onBackPressed: () -> Unit = {},
    title: String,
    hasBackButton: Boolean = true,
    textColor: Color = Color.White,
    backgroundColor: Color = greenApp,
) {

    MaterialTheme {

        Card(
            backgroundColor = backgroundColor,
            elevation = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 2.dp)
                .offset(y = (-5).dp),
            shape = RoundedCornerShape(12.dp)
        ) {

            if (hasBackButton) {

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_back_arrow),
                        contentDescription = "Back",
                        Modifier
                            .padding(start = 24.dp, top = 24.dp, bottom = 24.dp)
                            .size(35.dp)
                            .padding(7.dp)
                            .offset(y = 5.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = false),
                            ) {
                                onBackPressed.invoke()
                            },
                        tint = textColor
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                HeadlineSmallText(
                    text = title,
                    modifier = Modifier
                        .padding(top = 24.dp, bottom = 24.dp)
                        .offset(y = 5.dp),
                    colors = textColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }


}