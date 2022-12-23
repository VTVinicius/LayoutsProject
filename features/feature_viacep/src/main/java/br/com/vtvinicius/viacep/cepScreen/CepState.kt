package br.com.vtvinicius.viacep.cepScreen

import br.com.vtvinicius.base_feature.core.Async
import br.com.vtvinicius.domain.model.example.EnderecoEntity

data class CepState(
    val endereco: Async<EnderecoEntity>,
    val saveAddress: Boolean?,
    var error: Throwable?,
    var lastCep: Async<String?>,
)
