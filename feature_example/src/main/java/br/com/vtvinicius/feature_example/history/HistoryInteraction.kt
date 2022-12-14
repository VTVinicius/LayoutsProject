package br.com.vtvinicius.feature_example.history

sealed class HistoryInteraction {
    object LoadAddress : HistoryInteraction()
}