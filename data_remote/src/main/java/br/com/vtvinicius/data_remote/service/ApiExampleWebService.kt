package br.com.vtvinicius.data_remote.service

import br.com.vtvinicius.data_remote.model.example.EnderecoResponse
import br.com.vtvinicius.data_remote.service.ExampleConstants.CEP
import br.com.vtvinicius.data_remote.service.ExampleConstants.ENDERECO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiExampleWebService {

    @GET(ENDERECO)
    suspend fun searchCep(
        @Path(CEP) cep: String,
    ): EnderecoResponse


}

object ExampleConstants {
    const val CEP = "cep"
    const val ENDERECO = "{$CEP}/json/"
}
