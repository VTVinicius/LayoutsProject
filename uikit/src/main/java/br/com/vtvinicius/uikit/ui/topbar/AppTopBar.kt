package br.com.vtvinicius.uikit.ui.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.green
import br.com.vtvinicius.uikit.base.white
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
) {

    MaterialTheme {

        Box(
            Modifier
                .fillMaxWidth()
                .background(green)
                .shadow(1.dp)
        ) {

            if (hasBackButton) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = "Back",
                    Modifier
                        .padding(start = 24.dp, top = 24.dp, bottom = 24.dp)
                        .size(35.dp)
                        .align(Alignment.CenterStart)
                        .padding(7.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = false),
                        ) {
                            onBackPressed.invoke()
                        }
                )
            }

            HeadlineSmallText(
                text = title,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 24.dp, bottom = 24.dp),
                colors = white,
                fontWeight = FontWeight.Bold
            )

        }

    }


}