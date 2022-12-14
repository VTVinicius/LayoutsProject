package br.com.vtvinicius.base_feature.core

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import br.com.vtvinicius.base_feature.dialogs.LoadingDialog


@Composable
fun <T> Scene(
    async: Async<T>,
    waiting: Boolean? = true,
    loading: @Composable () -> Unit = { LoadingDialog() },
    content: @Composable (T) -> Unit,
) {
    MaterialTheme {
        when (async) {
            is Async.Error -> error(async.message)
            is Async.Loading -> loading()
            is Async.Success -> content(async.value)
            is Async.Waiting -> waiting
        }
    }
}
