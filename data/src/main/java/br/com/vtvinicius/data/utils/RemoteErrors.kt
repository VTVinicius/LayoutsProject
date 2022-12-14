package br.com.vtvinicius.data.utils

import br.com.vtvinicius.domain.exception.DataSourceException

enum class ErrorMessageEnum(val value: String) {
    INTERNET_ERROR("Ocorreu um problema ao validar as informações. Verifique sua conexão de internet e tente novamente"),
    GENERIC_ERROR("Ocorreu um erro. Por favor tente novamente mais tarde!"),
}

open class RemoteDataSourceException(
    message: String = ErrorMessageEnum.GENERIC_ERROR.value,
    code: String,
    cause: Throwable? = null,
) : DataSourceException(message = message, cause = cause, code = code)

class ServerError(
    message: String = ErrorMessageEnum.GENERIC_ERROR.value,
    cause: Throwable? = null,
) : DataSourceException(message = message, cause = cause)
