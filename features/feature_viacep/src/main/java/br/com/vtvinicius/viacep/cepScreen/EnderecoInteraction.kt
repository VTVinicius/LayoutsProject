package br.com.vtvinicius.feature_example.cepScreen

sealed class EnderecoInteraction {
    data class SearchEndereco(val cep: String) : EnderecoInteraction()
    object CloseDialog : EnderecoInteraction()
}