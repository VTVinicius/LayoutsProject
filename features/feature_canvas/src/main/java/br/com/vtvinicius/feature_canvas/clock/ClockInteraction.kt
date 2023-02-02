package br.com.vtvinicius.feature_canvas.clock

sealed class ClockInteraction {
    object StartClock : ClockInteraction()
    object RunClock : ClockInteraction()
}