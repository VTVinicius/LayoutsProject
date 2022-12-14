package br.com.vtvinicius.data_local.datasource

import br.com.vtvinicius.data.local.datasource.AddressLocalDataSource
import br.com.vtvinicius.data_local.database.dao.ViaCepDao
import br.com.vtvinicius.data_local.mapper.address.AddressMapper.toDao
import br.com.vtvinicius.data_local.mapper.address.AddressMapper.toDomain
import br.com.vtvinicius.domain.model.example.AddressLocalEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class AddressLocalDataSourceImpl(
    private val viaCepDao: ViaCepDao,
) : AddressLocalDataSource {

    override fun saveAddress(address: AddressLocalEntity) {
        viaCepDao.addAddress(address = address.toDao())
    }

    override fun getAllAddress(): Flow<List<AddressLocalEntity>> = flow {
        viaCepDao.getAll().collect {
            val list = mutableListOf<AddressLocalEntity>()
            it.forEach { item ->
                list.add(item.toDomain())
            }
            emit(list)
        }
    }

}