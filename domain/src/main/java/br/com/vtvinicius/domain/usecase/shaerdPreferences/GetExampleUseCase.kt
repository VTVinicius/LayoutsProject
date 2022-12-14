package br.com.vtvinicius.domain.usecase.shaerdPreferences

import br.com.vtvinicius.domain.core.UseCase
import br.com.vtvinicius.domain.repository.sharedPreferences.ExamplePreferencesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flow

class GetExampleUseCase(
    scope: CoroutineScope,
    private val repository: ExamplePreferencesRepository,
) : UseCase<String?, Unit>(scope = scope) {

    override fun run(params: Unit?) = flow { emit(repository.getExample()) }

}