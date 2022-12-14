package br.com.vtvinicius.domain.usecase.example

import br.com.vtvinicius.domain.core.UseCase
import br.com.vtvinicius.domain.exception.MissingParamsException
import br.com.vtvinicius.domain.model.example.EnderecoEntity
import br.com.vtvinicius.domain.repository.exampleRepository.ExampleRepository
import kotlinx.coroutines.CoroutineScope

class SearchCepUseCase(
    scope: CoroutineScope,
    private val repository: ExampleRepository,
) : UseCase<EnderecoEntity, SearchCepUseCase.Params>(scope) {

    override fun run(params: Params?) = when {
        params == null -> throw NullPointerException()
        params.cep.isBlank() -> throw MissingParamsException()
        else -> repository.searchCep(params.cep)
    }

    data class Params(
        val cep: String,
    )
}