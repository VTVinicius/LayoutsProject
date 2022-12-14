package br.com.vtvinicius.data.remote.datasource

import br.com.vtvinicius.domain.model.example.EnderecoEntity
import kotlinx.coroutines.flow.Flow

interface ExampleDataSource {

    fun searchCep(cep: String): Flow<EnderecoEntity>

}