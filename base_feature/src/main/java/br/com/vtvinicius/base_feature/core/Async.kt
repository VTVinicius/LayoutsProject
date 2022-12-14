package br.com.vtvinicius.base_feature.core

import kotlinx.coroutines.flow.MutableStateFlow

sealed class Async<out T> {
    object Loading : Async<Nothing>()
    object Waiting : Async<Nothing>()
    data class Error(val message: String) : Async<Nothing>()
    data class Success<T>(val value: T) : Async<T>()
}

infix fun <T> MutableStateFlow<T>.setState(state: T) {
    value = state
}

fun <T> MutableStateFlow<T?>.updateState(reducer: T.() -> T) {
    value?.let { value = reducer(it) }
}

fun <T> Async<T>.updateSuccessState(reducer: T.() -> T): Async<T> {
    return if (this is Async.Success) Async.Success(reducer(value)) else this
}

fun <T> Async<T>.asSuccessOrNull() = if (this is Async.Success) value else null
