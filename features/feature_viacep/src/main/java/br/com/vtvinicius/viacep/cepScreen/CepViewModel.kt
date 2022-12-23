package br.com.vtvinicius.viacep.cepScreen

import androidx.lifecycle.ViewModel
import br.com.vtvinicius.base_feature.core.Async
import br.com.vtvinicius.base_feature.extensions.useCase
import br.com.vtvinicius.domain.model.example.AddressLocalEntity
import br.com.vtvinicius.domain.model.example.EnderecoEntity
import br.com.vtvinicius.domain.usecase.example.SaveAddressUseCase
import br.com.vtvinicius.domain.usecase.example.SearchCepUseCase
import br.com.vtvinicius.domain.usecase.shaerdPreferences.GetExampleUseCase
import br.com.vtvinicius.domain.usecase.shaerdPreferences.SaveExampleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class CepViewModel : ViewModel(), KoinComponent {

    private val _state = MutableStateFlow(CepState(Async.Waiting, null, null, Async.Waiting))
    val state: StateFlow<CepState> = _state

    private val searchCepUseCase: SearchCepUseCase by useCase()
    private val saveAddressUseCase: SaveAddressUseCase by useCase()
    private val saveExampleUseCase: SaveExampleUseCase by useCase()
    private val getExampleUseCase: GetExampleUseCase by useCase()

    fun interact(interaction: EnderecoInteraction) {
        when (interaction) {
            is EnderecoInteraction.SearchEndereco -> searchCep(interaction.cep)
            is EnderecoInteraction.CloseDialog -> closeDialog()
            is EnderecoInteraction.ShowLastCep -> showLastCep()
        }
    }


    init {
        interact(EnderecoInteraction.ShowLastCep)
    }

    private fun searchCep(cep: String) {
        _state.update { it.copy(endereco = Async.Loading) }
        closeDialog()
        searchCepUseCase(
            params = SearchCepUseCase.Params(cep),
            onSuccess = {
                _state.update { cepState ->
                    cepState.copy(endereco = Async.Success(it))
                }
                saveAddress(it)
                saveLastCep(cep)
            },
            onError = {
                _state.update { cepState ->
                    cepState.copy(error = it)
                }
                _state.update { it.copy(endereco = Async.Waiting) }
            }
        )
    }

    private fun closeDialog() {
        _state.update { it.copy(error = null) }
    }

    private fun saveAddressLocal(address: AddressLocalEntity) {
        saveAddressUseCase(
            params = SaveAddressUseCase.Params(address),
            onSuccess = {
                _state.update { addressState ->
                    addressState.copy(saveAddress = true)
                }
            },
            onError = {
                _state.update { cepState ->
                    cepState.copy(error = it)
                }
                _state.update { it.copy(saveAddress = null) }
            }
        )
    }

    private fun modelConverter(address: EnderecoEntity): AddressLocalEntity {
        return AddressLocalEntity(
            cep = address.cep,
            logradouro = address.logradouro,
            complemento = address.complemento,
            bairro = address.bairro,
            localidade = address.localidade,
            uf = address.uf,
            ibge = address.ibge,
            gia = address.gia,
            ddd = address.ddd,
            siafi = address.siafi
        )
    }

    private fun validateAddress(address: EnderecoEntity): Boolean {
        return !(address.uf == "null" || address.uf == null)
    }

    private fun saveAddress(address: EnderecoEntity) {
        if (validateAddress(address)) {
            saveAddressLocal(modelConverter(address = address))
        }
    }

    private fun saveLastCep(cep: String) {
        saveExampleUseCase(
            params = SaveExampleUseCase.Params(cep),
            onSuccess = {
                interact(EnderecoInteraction.ShowLastCep)
            },
            onError ={
                interact(EnderecoInteraction.ShowLastCep)
            }
        )
    }

    private fun showLastCep() {
        getExampleUseCase(
            onSuccess = {
                _state.update { cepState ->
                    cepState.copy(lastCep = Async.Success(it))
                }
            }
        )
    }
}