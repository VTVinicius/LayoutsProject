package com.example.feature_social_media.linkedin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.feature_social_media.linkedin.components.CapeAndProfilePic
import com.example.feature_social_media.linkedin.components.CompanyAndLocation
import com.example.feature_social_media.linkedin.components.NameAndDescription
import com.example.feature_social_media.linkedin.components.TopButtonsRow


@Composable
fun LinkedinProfileScreen() {


    Scaffold(content = {

        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {

            CapeAndProfilePic()

            NameAndDescription()
            CompanyAndLocation()
            TopButtonsRow()

        }
    })
}
