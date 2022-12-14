package br.com.vtvinicius.uikit.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


class AppColors(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    background: Color,
    surface: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    isLight: Boolean,
) {
    var primary by mutableStateOf(primary)
    var primaryVariant by mutableStateOf(primaryVariant)
    var secondary by mutableStateOf(secondary)
    var background by mutableStateOf(background)
    var surface by mutableStateOf(surface)
    var onPrimary by mutableStateOf(onPrimary)
    var onSecondary by mutableStateOf(onSecondary)
    var onBackground by mutableStateOf(onBackground)
    var onSurface by mutableStateOf(onSurface)
    var isLight by mutableStateOf(isLight)

    fun copy(
        primary: Color = this.primary,
        primaryVariant: Color = this.primaryVariant,
        secondary: Color = this.secondary,
        background: Color = this.background,
        surface: Color = this.surface,
        onPrimary: Color = this.onPrimary,
        onSecondary: Color = this.onSecondary,
        onBackground: Color = this.onBackground,
        onSurface: Color = this.onSurface,
        isLight: Boolean = this.isLight,
    ): AppColors = AppColors(
        primary,
        primaryVariant,
        secondary,
        background,
        surface,
        onPrimary,
        onSecondary,
        onBackground,
        onSurface,
        isLight
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        primaryVariant = other.primaryVariant
        secondary = other.secondary
        background = other.background
        surface = other.surface
        onPrimary = other.onPrimary
        onSecondary = other.onSecondary
        onBackground = other.onBackground
        onSurface = other.onSurface
    }
}


fun appLightColors(
    primary: Color = black,
    primaryVariant: Color = black,
    secondary: Color = white,
    background: Color = Color.White,
    surface: Color = Color.White,
    onPrimary: Color = Color.White,
    onSecondary: Color = Color.Black,
    onBackground: Color = Color.Black,
    onSurface: Color = Color.Black,
): AppColors = AppColors(
    primary = primary,
    primaryVariant = primaryVariant,
    secondary = secondary,
    background = background,
    surface = surface,
    onPrimary = onPrimary,
    onSecondary = onSecondary,
    onBackground = onBackground,
    onSurface = onSurface,
    isLight = true
)

val LocalColors = staticCompositionLocalOf { appLightColors() }

//PALETA DE CORES \/

var white = Color(0xFFFFFFFF)
var black = Color(0xFF000000)
var green = Color(0xFF229642)
var inactive = Color(0xFFECEAEA)
