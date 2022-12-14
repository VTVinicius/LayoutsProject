package br.com.vtvinicius.data_remote.utils

import br.com.vtvinicius.data.utils.ErrorMessageEnum
import br.com.vtvinicius.data.utils.RemoteDataSourceException
import br.com.vtvinicius.data.utils.ServerError
import br.com.vtvinicius.data_remote.model.base.BaseResponse
import org.koin.core.component.KoinComponent
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ExampleRequestWrapperImpl : ExampleRequestWrapper, KoinComponent {


    override suspend fun <T> wrapperGenericResponse(
        call: suspend () -> BaseResponse<T>,
    ): T {
        val result = wrapper(call = call)
        return getSuccessResult(result)
    }

    @Synchronized
    override suspend fun <D> wrapper(retryCount: Int, call: suspend () -> D): D {
        return try {
            call().also { result ->
                if (result is BaseResponse<*>) {
                    getSuccessResult(result)
                }
            }
        } catch (unknownHostException: UnknownHostException) {
            throw ServerError(ErrorMessageEnum.INTERNET_ERROR.value)
        } catch (socketTimeoutException: SocketTimeoutException) {
            throw ServerError(ErrorMessageEnum.INTERNET_ERROR.value)
        } catch (ioException: IOException) {
            throw ServerError(cause = ioException)
        } catch (stateException: IllegalStateException) {
            throw ServerError(cause = stateException)
        }
    }

    private fun <T> getSuccessResult(result: BaseResponse<T>): T {
        return when {
            result.message.isNotEmpty() -> throw handleExceptionByMessage(
                result,
                "200"
            )
            result.dados == null -> throw NullPointerException()
            else -> result.dados
        }
    }

    private fun handleExceptionByMessage(
        result: BaseResponse<*>, code: String,
    ): Exception {
        val errors = result.message

        return if (!errors.isNullOrEmpty()) {
            RemoteDataSourceException(
                message = errors,
                code = code
            )
        } else RemoteDataSourceException(
            message = ErrorMessageEnum.GENERIC_ERROR.value,
            code = code
        )
    }
}
