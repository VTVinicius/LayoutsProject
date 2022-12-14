package br.com.vtvinicius.base_feature.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.vtvinicius.domain.core.UseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

//Função para facilitar a injeção de dependencia de br.com.vtvinicius.domain.core.UseCase na ViewModel
//Assim não precisa passar o br.com.vtvinicius.domain.core.UseCase por parametro na VM

//private val exemploUseCase: ExemploUseCase by br.com.vtvinicius.base_feature.extensions.useCase()

inline fun <V, reified U> V.useCase() where U : UseCase<*, *>, V : ViewModel, V : KoinComponent =
    inject<U> {
        parametersOf(viewModelScope)
    }