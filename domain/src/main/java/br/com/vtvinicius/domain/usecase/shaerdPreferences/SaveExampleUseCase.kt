package br.com.vtvinicius.domain.usecase.shaerdPreferences

import br.com.vtvinicius.domain.core.UseCase
import br.com.vtvinicius.domain.exception.MissingParamsException
import br.com.vtvinicius.domain.repository.sharedPreferences.ExamplePreferencesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flow


class SaveExampleUseCase(
    scope: CoroutineScope,
    private val repository: ExamplePreferencesRepository,
) : UseCase<Unit, SaveExampleUseCase.Params>(scope = scope) {

    override fun run(params: Params?) = flow {
        emit(
            when {
                params == null -> throw NullPointerException()
                params.example.isEmpty() -> throw MissingParamsException()
                else -> repository.saveExample(params.example)
            }
        )
    }

    data class Params(
        val example: String,
    )
}