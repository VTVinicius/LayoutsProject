package br.com.vtvinicius.data.local.repository.database

import br.com.vtvinicius.data.local.datasource.AddressLocalDataSource
import br.com.vtvinicius.domain.model.example.AddressLocalEntity
import br.com.vtvinicius.domain.repository.exampleRepository.AddressLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressLocalRepositoryImpl(
    private val addressDataSource: AddressLocalDataSource,
) : AddressLocalRepository {

    override fun saveAddress(address: AddressLocalEntity) =
        flow { emit(addressDataSource.saveAddress(address)) }

    override fun getAddress(): Flow<List<AddressLocalEntity>> = addressDataSource.getAllAddress()


}