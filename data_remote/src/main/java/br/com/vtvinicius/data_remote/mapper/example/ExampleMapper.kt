package br.com.vtvinicius.data_remote.mapper.example

import br.com.vtvinicius.data_remote.model.example.EnderecoResponse
import br.com.vtvinicius.data_remote.utils.DataRemoteMapper
import br.com.vtvinicius.domain.model.example.EnderecoEntity

object ExampleMapper : DataRemoteMapper<EnderecoResponse, EnderecoEntity>() {

    override fun toDomain(data: EnderecoResponse) = EnderecoEntity(
        cep = data.cep,
        logradouro = data.logradouro,
        complemento = data.complemento,
        bairro = data.bairro,
        localidade = data.localidade,
        uf = data.uf,
        ibge = data.ibge,
        gia = data.gia,
        ddd = data.ddd,
        siafi = data.siafi
    )
}