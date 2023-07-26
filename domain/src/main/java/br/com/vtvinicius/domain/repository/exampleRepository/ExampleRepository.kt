package br.com.vtvinicius.domain.repository.exampleRepository

import br.com.vtvinicius.domain.model.example.EnderecoEntity
import kotlinx.coroutines.flow.Flow

interface ExampleRepository {

    fun searchCep(cep: String): Flow<EnderecoEntity>


}