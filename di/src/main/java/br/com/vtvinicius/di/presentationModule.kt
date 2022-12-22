package br.com.vtvinicius.di

import br.com.vtvinicius.viacep.cepScreen.CepViewModel
import br.com.vtvinicius.viacep.history.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { CepViewModel() }
    viewModel { HistoryViewModel() }

}