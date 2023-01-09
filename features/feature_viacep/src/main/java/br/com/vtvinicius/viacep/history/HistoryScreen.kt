package br.com.vtvinicius.viacep.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.core.Scene
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.uikit.base.background
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import br.com.vtvinicius.viacep.history.components.AddressCard
import br.com.vtvinicius.viacep.navigation.FeatureExampleNavigation
import org.koin.androidx.compose.getViewModel

@Composable
fun HistoryScreen(
    navController: NavController,
    navigation: FeatureExampleNavigation,
) {

    val viewModel = getViewModel<HistoryViewModel>()
    val state by viewModel.state.collectAsState()
    val lazyState = rememberLazyListState()

    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Histórico",
                onBackPressed = { navigation.goToCepScreen(navController = navController) })
        },
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(background)) {

                Scene(async = state.address) { addressList ->

                    LazyColumn(state = lazyState) {

                        items(addressList.size) {

                            VerticalSpacer(height = 24)

                            AddressCard(
                                zipCode = addressList[it].cep,
                                uf = addressList[it].uf,
                                city = addressList[it].localidade,
                                neighborhood = addressList[it].bairro,
                                address = addressList[it].logradouro,
                            )
                        }
                    }
                }
            }
        })
}