package br.com.vtvinicius.domain.usecase.example

import br.com.vtvinicius.domain.core.UseCase
import br.com.vtvinicius.domain.model.example.AddressLocalEntity
import br.com.vtvinicius.domain.repository.exampleRepository.AddressLocalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetAddressListUseCase(
    scope: CoroutineScope,
    private val repository: AddressLocalRepository,
) : UseCase<List<AddressLocalEntity>, Unit>(scope) {

    override fun run(params: Unit?): Flow<List<AddressLocalEntity>> =
        repository.getAddress()

}