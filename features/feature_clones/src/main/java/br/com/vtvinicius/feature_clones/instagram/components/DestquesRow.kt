package br.com.vtvinicius.feature_clones.instagram.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.ui.text.LabelSmallText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


@Composable
fun DestaquesRow() {

    LazyRow(state = rememberLazyListState(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        content = {
            items(8) {

                HorizontalSpacer(width = 16 )
                IconDestque(index = it)
                HorizontalSpacer(width = 8)
            }

        })

}

@Composable
fun IconDestque(index: Int) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        RoundImage(image = painterResource(id = R.drawable.img_destaques), modifier = Modifier.size(60.dp) )
        VerticalSpacer(height = 4)
        LabelSmallText(text = "Destaque $index")
    }

}