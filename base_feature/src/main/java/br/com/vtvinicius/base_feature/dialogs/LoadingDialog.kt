package br.com.vtvinicius.base_feature.dialogs

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog

@Composable
fun LoadingDialog(
) {
    Dialog(
        onDismissRequest = { },
        content = { CircularProgressIndicator() }
    )
}