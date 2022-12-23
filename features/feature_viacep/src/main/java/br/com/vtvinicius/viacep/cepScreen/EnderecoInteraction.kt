package br.com.vtvinicius.viacep.cepScreen

sealed class EnderecoInteraction {
    data class SearchEndereco(val cep: String) : EnderecoInteraction()
    object CloseDialog : EnderecoInteraction()
    object ShowLastCep : EnderecoInteraction()
}