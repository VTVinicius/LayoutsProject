package br.com.vtvinicius.feature_canvas.clock


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.getViewModel

@Composable
fun ClockScreen() {

    val viewModel = getViewModel<ClockViewModel>()

    val state by viewModel.state.collectAsState()

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ClockExercise(
            seconds = state.seconds,
            minutes = state.minutes,
            hours = state.hours
        )

    }


}