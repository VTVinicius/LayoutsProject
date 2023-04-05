package br.com.vtvinicius.domain.repository.sharedPreferences

interface UserPreferencesRepository {

    fun saveUserLogged(value: Boolean)

    fun isUserLogged(): Boolean

}