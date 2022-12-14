package br.com.vtvinicius.data_remote.utils

import br.com.vtvinicius.data_remote.model.base.BaseResponse


interface ExampleRequestWrapper {

    suspend fun <T> wrapperGenericResponse(
        call: suspend () -> BaseResponse<T>,
    ): T

    suspend fun <D> wrapper(
        retryCount: Int = 0,
        call: suspend () -> D,
    ): D
}

