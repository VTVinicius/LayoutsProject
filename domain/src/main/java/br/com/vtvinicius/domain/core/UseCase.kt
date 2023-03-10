package br.com.vtvinicius.domain.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class UseCase<T, in Params>(private val scope: CoroutineScope) : KoinComponent {
    private val contextProvider: ThreadContextProvider by inject()

    abstract fun run(params: Params? = null): Flow<T>

    operator fun invoke(
        params: Params? = null,
        onError: ((Throwable) -> Unit) = {},
        onSuccess: (T) -> Unit = {},
        onFinally: (T) -> Unit = {},
    ) {
        scope.launch(contextProvider.io) {
            try {
                run(params).collect {
                    withContext(contextProvider.main) {
                        onSuccess(it)
                    }
                }
            } catch (e: Exception) {
                withContext(contextProvider.main) {
                    onError(e)
                }
            } finally {
                run(params).collect {
                    withContext(contextProvider.main) {
                        onFinally(it)
                    }
                }
            }
        }
    }

    fun cancel() = scope.coroutineContext.cancelChildren()
}
