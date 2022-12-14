package br.com.vtvinicius.data_remote.datasource

import br.com.vtvinicius.data.remote.datasource.ExampleDataSource
import br.com.vtvinicius.data_remote.mapper.example.ExampleMapper
import br.com.vtvinicius.data_remote.service.ApiExampleWebService
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent

class ExampleDataSourceImpl(
    private val webService: ApiExampleWebService,
) : ExampleDataSource, KoinComponent {

    override fun searchCep(cep: String) = flow {
        emit(
            ExampleMapper.toDomain(
                webService.searchCep(cep)
            )
        )
    }
}