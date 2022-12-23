package br.com.vtvinicius.viacep.cepScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.base_feature.core.Scene
import br.com.vtvinicius.base_feature.core.asSuccessOrNull
import br.com.vtvinicius.base_feature.dialogs.CustomError
import br.com.vtvinicius.base_feature.extensions.AppScaffold
import br.com.vtvinicius.base_feature.extensions.validateStateError
import br.com.vtvinicius.uikit.ui.button.AppButton
import br.com.vtvinicius.uikit.ui.inputtext.BasicInputText
import br.com.vtvinicius.uikit.ui.inputtext.base.InputTextState
import br.com.vtvinicius.uikit.ui.text.TitleMediumText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import br.com.vtvinicius.viacep.cepScreen.components.TextSpace
import br.com.vtvinicius.viacep.navigation.FeatureExampleNavigation
import org.koin.androidx.compose.getViewModel


@Composable
fun CepScreen(
    navController: NavController,
    navigation: FeatureExampleNavigation,
    viewModel: CepViewModel = getViewModel(),
) {

    val state by viewModel.state.collectAsState()

    AppScaffold(
        topBar = {
            AppTopBar(
                title = "Via CEP",
                onBackPressed = { navigation.goToSecondScreen(navController = navController) })
        },
        error = state.error?.validateStateError(),
        content = {
            Column {

                Scene(
                    async = state.endereco,
                ) {

                }

                CustomError(state.error, text = "Mensagem De Erro Pernsonalizada")

                VerticalSpacer(height = 32)

                BasicInputText(
                    hint = "Digite o CEP",
                    maxLength = 8,
                    onSearch = {
                        when (it.length) {
                            8 -> viewModel.interact(EnderecoInteraction.SearchEndereco(it))
                        }
                    },
                    state = InputTextState.OUTLINE,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                VerticalSpacer(height = 50)

                TextSpace(text = state.endereco.asSuccessOrNull()?.cep ?: "", title = "CEP")

                VerticalSpacer(height = 16)

                TextSpace(text = state.endereco.asSuccessOrNull()?.uf ?: "", title = "UF")

                VerticalSpacer(height = 16)

                TextSpace(
                    text = state.endereco.asSuccessOrNull()?.localidade ?: "",
                    title = "Cidade"
                )

                VerticalSpacer(height = 16)

                TextSpace(text = state.endereco.asSuccessOrNull()?.bairro ?: "", title = "Bairro")

                VerticalSpacer(height = 16)

                TextSpace(
                    text = state.endereco.asSuccessOrNull()?.logradouro ?: "",
                    title = "Logradouro"
                )

                VerticalSpacer(height = 32)

                TitleMediumText(text = "Ultimo CEP pesquisado: ${state.lastCep.asSuccessOrNull()}", modifier = Modifier.padding(horizontal = 16.dp))

                Column(
                    Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom,
                ) {

                    AppButton(
                        onClick = { navigation.goToHistoryScreen(navController = navController) },
                        text = " Histórico"
                    )
                }
            }
        }
    )
}

