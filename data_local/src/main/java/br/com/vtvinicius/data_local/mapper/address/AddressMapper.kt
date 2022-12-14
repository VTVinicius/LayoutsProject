package br.com.vtvinicius.data_local.mapper.address

import br.com.vtvinicius.data_local.database.model.AddressDataLocal
import br.com.vtvinicius.data_local.database.table.ViaCepLocal
import br.com.vtvinicius.domain.model.example.AddressLocalEntity

object AddressMapper {
    fun AddressLocalEntity.toDao() = ViaCepLocal(
        addressData = AddressDataLocal(
            cep = cep,
            logradouro = logradouro,
            complemento = complemento,
            bairro = bairro,
            localidade = localidade,
            uf = uf,
            ibge = ibge,
            gia = gia,
            ddd = ddd,
            siafi = siafi
        ),
        cep = cep ?: "null"
    )

    fun ViaCepLocal.toDomain() = AddressLocalEntity(
        cep = addressData.cep,
        logradouro = addressData.logradouro,
        complemento = addressData.complemento,
        bairro = addressData.bairro,
        localidade = addressData.localidade,
        uf = addressData.uf,
        ibge = addressData.ibge,
        gia = addressData.gia,
        ddd = addressData.ddd,
        siafi = addressData.siafi
    )
}