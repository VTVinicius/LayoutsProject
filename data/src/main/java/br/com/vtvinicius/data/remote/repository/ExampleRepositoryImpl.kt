package br.com.vtvinicius.data.remote.repository

import br.com.vtvinicius.data.remote.datasource.ExampleDataSource
import br.com.vtvinicius.domain.repository.exampleRepository.ExampleRepository

class ExampleRepositoryImpl(
    private val dataSource: ExampleDataSource,
) : ExampleRepository {

    override fun searchCep(cep: String) = dataSource.searchCep(cep)

}