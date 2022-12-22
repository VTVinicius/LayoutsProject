package br.com.vtvinicius.feature_example.history

import br.com.vtvinicius.base_feature.core.Async
import br.com.vtvinicius.domain.model.example.AddressLocalEntity

data class HistoryState(
    val address: Async<List<AddressLocalEntity>>,
    val error: Throwable?,
)
