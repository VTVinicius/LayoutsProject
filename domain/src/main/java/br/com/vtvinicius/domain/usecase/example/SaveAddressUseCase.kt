package br.com.vtvinicius.domain.usecase.example

import br.com.vtvinicius.domain.core.UseCase
import br.com.vtvinicius.domain.model.example.AddressLocalEntity
import br.com.vtvinicius.domain.repository.exampleRepository.AddressLocalRepository
import kotlinx.coroutines.CoroutineScope

class SaveAddressUseCase(
    scope: CoroutineScope,
    private val repository: AddressLocalRepository,
) : UseCase<Unit, SaveAddressUseCase.Params>(scope) {

    override fun run(params: Params?) = when (params) {
        null -> throw NullPointerException()
        else -> repository.saveAddress(params.address)
    }

    data class Params(
        val address: AddressLocalEntity,
    )
}