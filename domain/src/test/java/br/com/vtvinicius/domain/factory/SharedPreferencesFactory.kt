package br.com.vtvinicius.domain.factory

import br.com.vtvinicius.domain.usecase.shaerdPreferences.SaveExampleUseCase


object SharedPreferencesFactory {


    val DUMMY_EXAMPLE_PARAMS = SaveExampleUseCase.Params("example")
    val DUMMY_EXAMPLE_STRING = "example"
}