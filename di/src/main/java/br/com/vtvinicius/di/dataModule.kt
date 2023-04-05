package br.com.vtvinicius.di

import ExamplePreferencesRepositoryImpl
import br.com.vtvinicius.data.local.repository.database.AddressLocalRepositoryImpl
import br.com.vtvinicius.data.local.repository.sharedpreferences.UserPreferencesRepositoryImpl
import br.com.vtvinicius.data.remote.repository.ExampleRepositoryImpl
import br.com.vtvinicius.domain.repository.exampleRepository.AddressLocalRepository
import br.com.vtvinicius.domain.repository.exampleRepository.ExampleRepository
import br.com.vtvinicius.domain.repository.sharedPreferences.ExamplePreferencesRepository
import br.com.vtvinicius.domain.repository.sharedPreferences.UserPreferencesRepository
import org.koin.dsl.module

val dataModule = module {

    single<ExamplePreferencesRepository> { ExamplePreferencesRepositoryImpl(get()) }

    single<ExampleRepository> { ExampleRepositoryImpl(get()) }

    single<AddressLocalRepository> { AddressLocalRepositoryImpl(get()) }

    single<UserPreferencesRepository> { UserPreferencesRepositoryImpl(get()) }
}