package br.com.vtvinicius.domain.repository.exampleRepository

import br.com.vtvinicius.domain.model.example.AddressLocalEntity
import kotlinx.coroutines.flow.Flow

interface AddressLocalRepository {

    fun saveAddress(address: AddressLocalEntity): Flow<Unit>

    fun getAddress(): Flow<List<AddressLocalEntity>>

}