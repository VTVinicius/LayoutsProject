package br.com.vtvinicius.feature_canvas.games.sanke

data class Directions(
    var isGoingUp: Boolean = false,
    var isGoingDown: Boolean = false,
    var isGoingLeft: Boolean = false,
    var isGoingRight: Boolean = false,
)
