package br.com.vtvinicius.di

import br.com.vtvinicius.feature_example.cepScreen.CepViewModel
import br.com.vtvinicius.feature_example.history.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { CepViewModel() }
    viewModel { HistoryViewModel() }

}