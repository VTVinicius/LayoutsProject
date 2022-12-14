package br.com.vtvinicius.uikit.ui.inputtext.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


enum class InputTextState(val value: Int) {
    NORMAL(0),
    OUTLINE(1),
    GRAY(2),
    ERROR(3),
    PASSWORD(4),
    PASSWORD_ERROR(5);

    var rightIcon: Int? = null
    var textValue: String = ""

    @Composable
    fun getBorderColor(): Color = when (value) {
        OUTLINE.value -> Color.Black
        ERROR.value -> Color.Red
        PASSWORD.value -> Color.Gray
        PASSWORD_ERROR.value -> Color.Red
        else -> Color.Transparent
    }

    @Composable
    fun getBorderSize(): Dp = when (value) {
        OUTLINE.value -> 1.dp
        ERROR.value -> 1.dp
        PASSWORD.value -> 1.dp
        PASSWORD_ERROR.value -> 1.dp
        else -> 0.dp
    }

    @Composable
    fun getBackgroundColor(): Color = when (value) {
        GRAY.value -> Color.Gray
        else -> Color.White
    }

    fun getPasswordIcon(icon: Int?) = when (value) {
        PASSWORD.value -> rightIcon = icon
        PASSWORD_ERROR.value -> rightIcon = icon
        else -> rightIcon = null
    }
}