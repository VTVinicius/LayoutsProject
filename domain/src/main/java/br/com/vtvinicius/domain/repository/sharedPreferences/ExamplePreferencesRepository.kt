package br.com.vtvinicius.domain.repository.sharedPreferences

interface ExamplePreferencesRepository {

    fun saveExample(value: String)

    fun getExample(): String?

}