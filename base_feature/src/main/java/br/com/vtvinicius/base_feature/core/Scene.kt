package br.com.vtvinicius.base_feature.core

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import br.com.vtvinicius.base_feature.dialogs.ErrorDialog
import br.com.vtvinicius.base_feature.dialogs.LoadingDialog
import br.com.vtvinicius.domain.core.validateErrors


@Composable
fun <T> Scene(
    async: Async<T>,
    waiting: Boolean? = true,
    loading: @Composable () -> Unit = { LoadingDialog() },
    content: @Composable (T) -> Unit,
    error: () -> Unit
) {

    MaterialTheme {
        when (async) {
            is Async.Error -> {
                ValidateErrors(async.message, onDismiss =
                error)
            }
            is Async.Loading -> loading()
            is Async.Success -> content(async.value)
            is Async.Waiting -> waiting
        }
    }


}

@Composable
fun ValidateErrors(error: Throwable?, onDismiss: () -> Unit) {

    var showError by remember {
        mutableStateOf(true)
    }

    ErrorDialog(
        showError = showError,
        error = validateErrors(error),
        onDismiss = {
            showError = false
            onDismiss()
        }
    )

}