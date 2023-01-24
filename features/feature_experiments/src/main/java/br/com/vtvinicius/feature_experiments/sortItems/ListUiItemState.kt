package br.com.vtvinicius.feature_experiments.sortItems

import androidx.compose.ui.graphics.Color

data class ListUiItemState(
    val id: Int,
    val isCurrentlyCompared: Boolean,
    val value: Int,
    val color: Color
)
