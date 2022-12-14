package br.com.vtvinicius.di

import br.com.vtvinicius.data.remote.datasource.ExampleDataSource
import br.com.vtvinicius.data_remote.datasource.ExampleDataSourceImpl
import br.com.vtvinicius.data_remote.service.ApiExampleWebService
import br.com.vtvinicius.data_remote.utils.API_URL
import br.com.vtvinicius.data_remote.utils.ExampleRequestWrapper
import br.com.vtvinicius.data_remote.utils.ExampleRequestWrapperImpl
import br.com.vtvinicius.data_remote.utils.WebServiceFactory
import org.koin.dsl.bind
import org.koin.dsl.module

val dataRemoteModule = module {

    single {
        WebServiceFactory.provideOkHttpClient(
            wasDebugVersion = true
        )
    }

    single {
        WebServiceFactory.createWebService(
            get(),
            url = API_URL
        ) as ApiExampleWebService
    }

    single { ExampleRequestWrapperImpl() } bind ExampleRequestWrapper::class

    single<ExampleDataSource> { ExampleDataSourceImpl(get()) }

}