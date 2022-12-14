package br.com.vtvinicius.data_local.datasource

import br.com.vtvinicius.data.local.datasource.ExamplePreferencesDataSource
import br.com.vtvinicius.data.utils.keys.ExamplePreferencesKeys
import br.com.vtvinicius.data_local.PreferencesHelper

class ExamplePreferencesDataSourceImpl(
    private val preferencesHelper: PreferencesHelper,
) : ExamplePreferencesDataSource {

    override fun saveExample(value: String) {
        preferencesHelper.saveString(ExamplePreferencesKeys.EXAMPLE.name, value)
    }

    override fun getExample(): String? {
        return preferencesHelper.getString(ExamplePreferencesKeys.EXAMPLE.name)
    }
}