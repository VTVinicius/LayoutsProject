package br.com.vtvinicius.uikit.utils.extensions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@Composable
fun androidx.compose.ui.Modifier.BaseButton() =
    androidx.compose.ui.Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)