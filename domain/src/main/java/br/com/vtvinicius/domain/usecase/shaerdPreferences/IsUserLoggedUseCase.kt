package br.com.vtvinicius.domain.usecase.shaerdPreferences

import br.com.vtvinicius.domain.core.UseCase
import br.com.vtvinicius.domain.repository.sharedPreferences.UserPreferencesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flow

class IsUserLoggedUseCase(
    scope: CoroutineScope,
    private val repository: UserPreferencesRepository,
) : UseCase<Boolean?, Unit>(scope = scope) {

    override fun run(params: Unit?) = flow { emit(repository.isUserLogged()) }

}