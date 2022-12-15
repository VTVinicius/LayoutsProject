package com.example.feature_social_media

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.uikit.ui.button.AppButton

@Composable
fun LobbySocialMedias(navController: NavController, navigation: SocialMediaNavigation) {



    Column(Modifier.fillMaxSize()) {

        AppButton(onClick = { navigation.goToInstagram(navController)}, text = "Instagram")

    }

}