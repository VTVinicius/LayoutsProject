package br.com.vtvinicius.viacep

import br.com.vtvinicius.domain.model.example.AddressLocalEntity
import br.com.vtvinicius.domain.model.example.EnderecoEntity

object ViaCepViewModelFactory {
    val DUMMY_ADDRESS_ENTITY = EnderecoEntity(
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
    val DUMMY_ADDRESS_LOCAL_ENTITY_ERROR = AddressLocalEntity(
        cep = "883600",
        logradouro = "Rua dos Bos",
        complemento = "casa 1",
        bairro = "Centro",
        localidade = "Itajaí",
        uf = "SC",
        ibge = "4205407",
        gia = "1004",
        ddd = "47",
        siafi = "7107"
    )

    const val DUMMY_SUCCESS_CEP = "88350001"
    const val DUMMY_ERROR_CEP = ""
}