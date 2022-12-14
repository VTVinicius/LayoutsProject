package br.com.vtvinicius.base_feature.extensions

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*

@Composable
fun ScrollState.OnBottomReached(
    offset: Int = 0,
    loadMore: () -> Unit,
) {
    val shouldLoadMore = remember {
        derivedStateOf {
            this.value >= (this.maxValue - offset)
        }
    }

    // Convert the state into a cold flow and collect
    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .collect {
                if (it) loadMore()
            }
    }
}

@Composable
fun LazyListState.OnBottomReached(
    offset: Int = 1,
    loadMore: () -> Unit,
) {

    val shouldLoadMore = remember {
        derivedStateOf {
            layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - offset
        }
    }

    // Convert the state into a cold flow and collect
    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .collect {
                if (it) loadMore()
            }
    }
}

