package br.com.vtvinicius.data.local.datasource

interface UserPreferencesDataSource {

    fun saveUserLogged(value: Boolean)

    fun isUserLogged(): Boolean
}