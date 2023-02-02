package br.com.vtvinicius.feature_canvas.clock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import java.util.*

class ClockViewModel : ViewModel(), KoinComponent {


    private var jobClock: Job? = null

    private val calendar = Calendar.getInstance()

    private val _state = MutableStateFlow(
        ClockState(
            calendar.get(Calendar.SECOND).toFloat(),
            calendar.get(Calendar.MINUTE).toFloat(),
            calendar.get(Calendar.HOUR_OF_DAY).toFloat()
        )
    )
    val state: StateFlow<ClockState> = _state

    fun interact(interaction: ClockInteraction) {
        when (interaction) {
            is ClockInteraction.RunClock -> runClock()
            else -> {}
        }
    }

    init {
        interact(ClockInteraction.RunClock)
    }

    private fun runClock() {
        jobClock = viewModelScope.launch {
            delay(1000)
            _state.update {
                it.copy(minutes = _state.value.minutes + 6f / 360f)
            }
            _state.update {
                it.copy(hours = _state.value.hours + 6f / (360f * 12f))
            }
            _state.update {
                it.copy(seconds = _state.value.seconds + 1f)
            }
            interact(ClockInteraction.RunClock)
        }
    }


}