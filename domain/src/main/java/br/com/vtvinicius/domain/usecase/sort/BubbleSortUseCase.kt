package br.com.vtvinicius.domain.usecase.sort

import br.com.vtvinicius.domain.core.UseCase
import br.com.vtvinicius.domain.model.example.SortInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class BubbleSortUseCase(
    scope: CoroutineScope,
) : UseCase<SortInfo, BubbleSortUseCase.Params>(scope = scope) {


    override fun run(params: Params?):  Flow<SortInfo>  = flow {

        var listSizeToCompare = if (params?.list?.size == null) 0 else params.list.size - 1
        while (listSizeToCompare > 1) {
            var innerIterator = 0
            while (innerIterator < listSizeToCompare) {
                val currentListItem = params?.list?.get(innerIterator)
                val nextListItem = params?.list?.get(innerIterator + 1)
                emit(
                    SortInfo(currentItem = innerIterator, shouldSwap = false, hadNoEffect = false)
                )
                delay(500)
                if (currentListItem!! > nextListItem!!) {
                    params.list.swap(innerIterator, innerIterator + 1)
                    emit(
                        SortInfo(
                            currentItem = innerIterator,
                            shouldSwap = true,
                            hadNoEffect = false
                        )
                    )
                } else {
                    emit(
                        SortInfo(
                            currentItem = innerIterator,
                            shouldSwap = false,
                            hadNoEffect = true
                        )
                    )
                }
                delay(500)
                innerIterator += 1
            }
            listSizeToCompare -= 1
        }

    }
    data class Params(
        val list: MutableList<Int>,
    )

}

fun <T> MutableList<T>.swap(indexOne: Int, indexTwo: Int) {
    val tempOne = this[indexOne]
    this[indexOne] = this[indexTwo]
    this[indexTwo] = tempOne
}


