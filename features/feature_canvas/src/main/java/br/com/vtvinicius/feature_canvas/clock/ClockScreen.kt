package br.com.vtvinicius.feature_canvas.clock


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import java.util.*

@Composable
fun ClockScreen() {

    val calendar = Calendar.getInstance()

    var seconds by remember {
        mutableStateOf((calendar.get(Calendar.SECOND)).toFloat())
    }
    var minutes by remember {
        mutableStateOf(calendar.get(Calendar.MINUTE ).toFloat())
    }
    var hours by remember {
        mutableStateOf(calendar.get(Calendar.HOUR_OF_DAY).toFloat())
    }

    LaunchedEffect(key1 = seconds) {
        delay(1000)
        minutes += 6f / 360f
        hours += 6f / (360f * 12f)
        seconds += 1f
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ClockExercise(
            seconds = seconds,
            minutes = minutes,
            hours = hours
        )

    }


}