package br.com.vtvinicius.data_local.datasource

import br.com.vtvinicius.data.local.datasource.UserPreferencesDataSource
import br.com.vtvinicius.data.utils.keys.UserPreferencesKeys
import br.com.vtvinicius.data_local.PreferencesHelper

class UserPreferencesDataSourceImpl(
    private val preferencesHelper: PreferencesHelper,
) : UserPreferencesDataSource {

    override fun saveUserLogged(value: Boolean) {
        preferencesHelper.saveBoolean(UserPreferencesKeys.USER_LOGGED.name, value)
    }

    override fun isUserLogged(): Boolean {
        return preferencesHelper.getBoolean(UserPreferencesKeys.USER_LOGGED.name)
    }
}