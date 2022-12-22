package br.com.vtvinicius.feature_canvas.gender_picker

sealed class Gender {
    object Male : Gender()
    object Female : Gender()
}