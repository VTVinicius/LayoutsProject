package br.com.vtvinicius.feature_clones

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun LobbySocialMedias(navController: NavController, navigation: FeatureClonesNavigation) {



    Column(Modifier.fillMaxSize()) {

        AppButton(onClick = { navigation.goToInstagram(navController)}, text = "Instagram")
        
        VerticalSpacer(height = 32)
        
        AppButton(onClick = { navigation.goToLinkedin(navController)}, text = "Linkedin")

    }

}