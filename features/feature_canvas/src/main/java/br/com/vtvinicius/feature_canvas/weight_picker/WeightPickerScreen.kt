package br.com.vtvinicius.feature_canvas.weight_picker


import android.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeightPickerScreen() {

    var weight by remember {
        mutableStateOf(80)
    }

    Column(Modifier.fillMaxSize()) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Selecione seu Peso",
                fontSize = 35.sp
            )
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    "$weight",
                    this.clipBounds.exactCenterX(),
                    this.clipBounds.exactCenterY(),
                    Paint().apply {
                        color = Color.BLACK
                        textSize = 150f
                        textAlign = Paint.Align.CENTER
                    },
                )
                drawText(
                    "Kg",
                    this.clipBounds.centerX() + 150f.toFloat(),
                    this.clipBounds.exactCenterY(),
                    Paint().apply {
                        color = Color.GREEN
                        textSize = 70f
                    },
                )
            }
        }
    }

    Box(Modifier.fillMaxSize()) {

        WeightPicker(
            style = ScaleStyle(
                scaleWidth = 150.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.BottomCenter),
        ) {
            weight = it
        }

    }
}

