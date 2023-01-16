package br.com.vtvinicius.feature_experiments.shimmer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.base_feature.extensions.shimmerEffect
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer


@Composable
fun ShimmerListItem(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {

    if (isLoading) {

        Row(modifier = modifier) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .shimmerEffect()
            )

            HorizontalSpacer(width = 16)

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .shimmerEffect()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(20.dp)
                        .shimmerEffect()
                )
            }
        }
    } else {
        contentAfterLoading()
    }
}

@Composable
fun ShimmerButtonItem(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {

    if (isLoading) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .shimmerEffect()
            )
        }
    } else {
        contentAfterLoading()
    }
}