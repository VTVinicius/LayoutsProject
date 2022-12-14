package br.com.vtvinicius.di

import br.com.vtvinicius.data.local.datasource.AddressLocalDataSource
import br.com.vtvinicius.data.local.datasource.ExamplePreferencesDataSource
import br.com.vtvinicius.data_local.PreferencesHelper
import br.com.vtvinicius.data_local.datasource.AddressLocalDataSourceImpl
import br.com.vtvinicius.data_local.datasource.ExamplePreferencesDataSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataLocalModule = module {

    single { PreferencesHelper(androidApplication()) }

    single<ExamplePreferencesDataSource> { ExamplePreferencesDataSourceImpl(get()) }

    single<AddressLocalDataSource> { AddressLocalDataSourceImpl(get()) }

}