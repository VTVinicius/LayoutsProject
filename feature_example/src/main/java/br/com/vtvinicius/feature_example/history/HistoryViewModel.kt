package br.com.vtvinicius.feature_example.history

import androidx.lifecycle.ViewModel
import br.com.vtvinicius.base_feature.core.Async
import br.com.vtvinicius.base_feature.extensions.useCase
import br.com.vtvinicius.domain.usecase.example.GetAddressListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class HistoryViewModel : ViewModel(), KoinComponent {

    private val _state = MutableStateFlow(HistoryState(Async.Waiting, null))
    val state: StateFlow<HistoryState> = _state

    private val getAddressListUseCase: GetAddressListUseCase by useCase()


    fun interact(interaction: HistoryInteraction) {
        when (interaction) {
            is HistoryInteraction.LoadAddress -> loadAddress()
        }
    }

    init {
        interact(HistoryInteraction.LoadAddress)
    }

    private fun loadAddress() {
        _state.update { it.copy(address = Async.Loading) }
        closeDialog()
        getAddressListUseCase(
            onSuccess = {
                _state.update { cepState ->
                    cepState.copy(address = Async.Success(it))
                }
            },
            onError = {
                _state.update { cepState ->
                    cepState.copy(error = it)
                }
                _state.update { it.copy(address = Async.Waiting) }
            }
        )
    }

    private fun closeDialog() {
        _state.update { it.copy(error = null) }
    }


}