package br.com.vtvinicius.data.local.repository.sharedpreferences

import br.com.vtvinicius.data.local.datasource.UserPreferencesDataSource
import br.com.vtvinicius.domain.repository.sharedPreferences.UserPreferencesRepository

class UserPreferencesRepositoryImpl(
    private val dataSource: UserPreferencesDataSource,
) : UserPreferencesRepository {

    override fun saveUserLogged(value: Boolean) {
        dataSource.saveUserLogged(value)
    }

    override fun isUserLogged(): Boolean {
        return dataSource.isUserLogged()
    }


}