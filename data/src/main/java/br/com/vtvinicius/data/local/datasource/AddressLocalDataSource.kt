package br.com.vtvinicius.data.local.datasource

import br.com.vtvinicius.domain.model.example.AddressLocalEntity
import kotlinx.coroutines.flow.Flow

interface AddressLocalDataSource {

    fun saveAddress(address: AddressLocalEntity)

    fun getAllAddress(): Flow<List<AddressLocalEntity>>

}