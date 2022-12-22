package br.com.vtvinicius.feature_canvas.games.tic_tac_toe

sealed class Player(val symbol: Char) {
    object X : Player('X')
    object O : Player('O')

    operator fun not(): Player {
        return if (this is X) O else X
    }
}