package br.com.vtvinicius.domain.usecase.viacep

import br.com.vtvinicius.domain.model.example.AddressLocalEntity
import br.com.vtvinicius.domain.usecase.example.SearchCepUseCase

object ViaCepFactory {

    val DUMMY_CEP_STRING = "88360000"
    val DUMMY_SEARCH_CEP_PARAMS = SearchCepUseCase.Params(DUMMY_CEP_STRING)
    val DUMMY_EMPTY_CEP = ""
    val DUMMY_ADDRESS_LOCAL_ENTITY = AddressLocalEntity(
        cep = "88360000",
        logradouro = "Rua dos Bobos",
        complemento = "casa 1",
        bairro = "Centro",
        localidade = "Itajaí",
        uf = "SC",
        ibge = "4205407",
        gia = "1004",
        ddd = "47",
        siafi = "7107"
    )
}