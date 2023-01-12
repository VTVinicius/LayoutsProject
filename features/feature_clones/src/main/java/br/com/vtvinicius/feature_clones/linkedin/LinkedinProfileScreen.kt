package br.com.vtvinicius.feature_clones.linkedin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.feature_clones.linkedin.components.*
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer


@Composable
fun LinkedinProfileScreen() {


    Scaffold(content = {

        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {

            CapeAndProfilePic()

            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                NameAndDescription()
                CompanyAndLocation()
                VerticalSpacer(height = 8)
                TopButtonsRow()
            }
            DividerLinkedin()
        }
    })
}
