package br.com.vtvinicius.feature_experiments.sortItems

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.vtvinicius.base_feature.extensions.useCase
import br.com.vtvinicius.domain.usecase.sort.BubbleSortUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import java.util.*

class SortViewModel : ViewModel(), KoinComponent {

    private val bubbleSortUseCase: BubbleSortUseCase by useCase()

    var listToSort = mutableStateListOf<ListUiItemState>()

    init {
        for (i in 0 until 9) {
            val rnd = Random()
            listToSort.add(
                ListUiItemState(
                    id = i,
                    isCurrentlyCompared = false,
                    value = rnd.nextInt(150),
                    color = Color(
                        255,
                        rnd.nextInt(256),
                        rnd.nextInt(256),
                        255
                    )
                )
            )
        }
    }

    fun startSorting() {
        viewModelScope.launch {
        bubbleSortUseCase(params = BubbleSortUseCase.Params(listToSort.map { listUiItem ->
            listUiItem.value
        } as MutableList<Int>),
            onSuccess = { swapInfo ->
                val currentItemIndex = swapInfo.currentItem
                listToSort[currentItemIndex] =
                    listToSort[currentItemIndex].copy(isCurrentlyCompared = true)
                listToSort[currentItemIndex + 1] =
                    listToSort[currentItemIndex + 1].copy(isCurrentlyCompared = true)

                if (swapInfo.shouldSwap) {
                    val firstItem = listToSort[currentItemIndex].copy(isCurrentlyCompared = false)
                    listToSort[currentItemIndex] =
                        listToSort[currentItemIndex + 1].copy(isCurrentlyCompared = false)
                    listToSort[currentItemIndex + 1] = firstItem
                }
                if (swapInfo.hadNoEffect) {
                    listToSort[currentItemIndex] =
                        listToSort[currentItemIndex].copy(isCurrentlyCompared = false)
                    listToSort[currentItemIndex + 1] =
                        listToSort[currentItemIndex + 1].copy(isCurrentlyCompared = false)
                }
            }, onError = {})
    }
}}
