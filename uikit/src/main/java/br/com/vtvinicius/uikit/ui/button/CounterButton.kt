package br.com.vtvinicius.uikit.ui.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.ui.text.TitleLargeText


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CounterButton(
    modifier: Modifier = Modifier,
    buttonColor: Color = Color.White,
    borderColor: Color = Color.Black,
    onClickAdd: () -> Unit,
    onClickRemove: () -> Unit,
    maxCount: Int = 20
) {

    var counter by remember {
        mutableStateOf(0)
    }

    fun incrementValue() {
        if (counter != maxCount) {
            if (counter < maxCount) {
                counter++
                onClickAdd()
            }
        }
    }

    fun decrementCounter() {
        if (counter != 0) {
            if (counter > 0) {
                counter--
                onClickRemove()
            }
        }
    }


    Card(
        modifier = modifier,
        backgroundColor = buttonColor,
        border = BorderStroke(1.dp, borderColor),
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                IconButton(onClick = { decrementCounter() }, content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_remove),
                        contentDescription = "Remove"
                    )
                })

                TitleLargeText(text = counter.toString())

                IconButton(onClick = { incrementValue() }, content = {
                    Icon(Icons.Filled.Add, contentDescription = "Adicionar")
                }
                )

            }
        },
        shape = RoundedCornerShape(8.dp),
    )
}

@Preview
@Composable
fun CounterPreview() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        CounterButton(onClickAdd = { /*TODO*/ }, onClickRemove = {})
    }
}
