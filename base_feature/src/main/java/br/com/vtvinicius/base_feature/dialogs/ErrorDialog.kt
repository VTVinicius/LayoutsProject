package br.com.vtvinicius.base_feature.dialogs

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.vtvinicius.base_feature.extensions.isCommonError

@Composable
fun ErrorDialog(
    showError: Boolean,
    error: String,
    onDismiss: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
        AlertDialog(
            onDismissRequest = { onDismiss(false) },
            title = { Text("Erro!", style = MaterialTheme.typography.h6) },
            text = { Text(error) },
            confirmButton = {
                Button(onClick = {onDismiss(false) }) {
                    Text(text = "OK", color = Color.White, style = MaterialTheme.typography.button)
                }
            },
            modifier = modifier
        )
}

@Composable
fun CustomError(
    state: Throwable?,
    text: String = "Ocorreu um Erro",
) {
    var showError by remember {
        mutableStateOf(true)
    }

    if (state == null) {
        showError = true
    }

    if (state?.isCommonError() == false) {
        ErrorDialog(
            showError = showError,
            error = state.message ?: text,
            onDismiss = { showError = false })
    }
}
