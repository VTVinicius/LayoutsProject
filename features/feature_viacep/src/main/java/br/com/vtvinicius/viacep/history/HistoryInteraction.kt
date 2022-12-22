package br.com.vtvinicius.viacep.history

sealed class HistoryInteraction {
    object LoadAddress : HistoryInteraction()
}