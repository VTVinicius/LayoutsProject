package br.com.vtvinicius.base_feature.extensions

import br.com.vtvinicius.domain.exception.DataSourceException
import java.net.ConnectException
import java.net.UnknownHostException


fun Throwable.isCommonError(): Boolean {

    return when (this) {
        is DataSourceException -> true
        is ConnectException -> true
        is UnknownHostException -> true
        else -> false
    }

}

fun Throwable.validateStateError(): Throwable? {
    return if (this.isCommonError()) this else null
}