package br.com.vtvinicius.data.local.datasource

interface ExamplePreferencesDataSource {

    fun saveExample(value: String)

    fun getExample(): String?

}