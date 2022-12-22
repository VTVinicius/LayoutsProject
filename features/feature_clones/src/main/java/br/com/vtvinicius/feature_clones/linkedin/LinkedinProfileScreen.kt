package br.com.vtvinicius.feature_clones.linkedin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.vtvinicius.feature_clones.linkedin.components.CapeAndProfilePic
import br.com.vtvinicius.feature_clones.linkedin.components.CompanyAndLocation
import br.com.vtvinicius.feature_clones.linkedin.components.NameAndDescription
import br.com.vtvinicius.feature_clones.linkedin.components.TopButtonsRow


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
