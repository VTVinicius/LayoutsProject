package com.example.feature_social_media.instagram

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import com.example.feature_social_media.instagram.components.*

@Composable
fun InstaProfileScreen() {

    Scaffold(
        topBar = {
            InstaTopBar(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )
        },
        content = {

            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()) {
                ProfileStats()
                DescriptionComponent()
                FallowedByRow()
                VerticalSpacer(height = 16)
                ButtonsMiddleRow()
                DestaquesRow()
            }

        })
}

