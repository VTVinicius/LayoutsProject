package br.com.vtvinicius.domain.usecase.shaerdPreferences

import br.com.vtvinicius.domain.core.UseCase
import br.com.vtvinicius.domain.repository.sharedPreferences.UserPreferencesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flow


class SaveUserLoggedUseCase(
    scope: CoroutineScope,
    private val repository: UserPreferencesRepository,
) : UseCase<Unit, SaveUserLoggedUseCase.Params>(scope = scope) {

    override fun run(params: Params?) = flow {
        emit(
            when (params) {
                null -> throw NullPointerException()
                else -> repository.saveUserLogged(params.isLogged)
            }
        )
    }

    data class Params(
        val isLogged: Boolean,
    )
}