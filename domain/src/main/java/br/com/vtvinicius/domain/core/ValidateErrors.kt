package br.com.vtvinicius.domain.core

import br.com.vtvinicius.domain.exception.DataSourceException
import java.net.ConnectException
import java.net.UnknownHostException

fun validateErrors(error: Throwable?): String? {

    return when (error) {
        is DataSourceException -> "Erro desconhecido"
        is ConnectException -> "Sem conexão com a internet"
        is UnknownHostException -> "Sem conexão com a internet"
        else -> null
    }


}