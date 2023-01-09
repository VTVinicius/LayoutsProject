package br.com.vtvinicius.feature_uikit.inputText

import CPFInputText
import CepInputText
import EmailInputText
import MoneyInputText
import NameInputText
import OnlyLettersInputText
import OnlyNumbersInputText
import PasswordInputText
import PhoneInputText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.vtvinicius.feature_uikit.FeatureUikitNavigation
import br.com.vtvinicius.uikit.base.background
import br.com.vtvinicius.uikit.base.purpleUikitDark
import br.com.vtvinicius.uikit.base.purpleUikitLight
import br.com.vtvinicius.uikit.ui.button.SmallButton
import br.com.vtvinicius.uikit.ui.inputtext.BasicInputText
import br.com.vtvinicius.uikit.ui.inputtext.base.InputTextState
import br.com.vtvinicius.uikit.ui.text.LabelLargeText
import br.com.vtvinicius.uikit.ui.topbar.AppTopBar
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer

@Composable
fun InputTextScreen(
    navController: NavController,
    navigation: FeatureUikitNavigation
) {

    val rowState = rememberLazyListState()

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Campos de Texto",
                textColor = purpleUikitDark,
                backgroundColor = purpleUikitLight,
                onBackPressed = { navigation.popBackStack(navController) }
            )
        },
        content = {


            var style by remember { mutableStateOf(InputTextState.NORMAL) }

            var styleOption by remember {
                mutableStateOf(0)
            }


            when (styleOption) {
                0 -> {
                    style = InputTextState.OUTLINE
                }
                1 -> {
                    style = InputTextState.NORMAL
                }
                2 -> {
                    style = InputTextState.GRAY
                }
                3 -> {
                    style = InputTextState.ERROR
                }

            }

            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(state = rememberScrollState())
                    .background(background)

            ) {


                VerticalSpacer(height = 24)

                LazyRow(state = rowState,
                    content = {
                        item {
                            HorizontalSpacer(width = 8)
                            SmallButton(
                                backgroundColor = purpleUikitLight,
                                textColor = purpleUikitDark,
                                onClick = { styleOption = 0 },
                                text = "Outline",
                                modifier = Modifier.size(width = 100.dp, height = 42.dp)
                            )
                            HorizontalSpacer(width = 8)
                            SmallButton(
                                backgroundColor = purpleUikitLight,
                                textColor = purpleUikitDark,
                                onClick = { styleOption = 1 },
                                text = "Normal",
                                modifier = Modifier.size(width = 100.dp, height = 42.dp)
                            )
                            HorizontalSpacer(width = 8)
                            SmallButton(
                                backgroundColor = purpleUikitLight,
                                textColor = purpleUikitDark,
                                onClick = { styleOption = 2 },
                                text = "Gray",
                                modifier = Modifier.size(width = 100.dp, height = 42.dp)
                            )
                            HorizontalSpacer(width = 8)
                            SmallButton(
                                backgroundColor = purpleUikitLight,
                                textColor = purpleUikitDark,
                                onClick = { styleOption = 3 },
                                text = "Error",
                                modifier = Modifier.size(width = 100.dp, height = 42.dp)
                            )
                            HorizontalSpacer(width = 8)
                        }
                    }
                )
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {


                    VerticalSpacer(height = 24)

                    LabelLargeText(text = "Input de Texto para Dinheiro.")

                    VerticalSpacer(height = 8)

                    MoneyInputText(onSearch = {}, state = style)

                    VerticalSpacer(height = 24)

                    LabelLargeText(text = "Input de Texto para CEP.")

                    VerticalSpacer(height = 8)

                    CepInputText(onSearch = {}, state = style)

                    VerticalSpacer(height = 16)

                    LabelLargeText(text = "Input de Texto para CPF.")

                    VerticalSpacer(height = 8)

                    CPFInputText(onSearch = {}, state = style)

                    VerticalSpacer(height = 16)

                    LabelLargeText(text = "Input de Texto para Email.")

                    VerticalSpacer(height = 8)

                    EmailInputText(onSearch = {}, state = style)

                    VerticalSpacer(height = 16)

                    LabelLargeText(text = "Input de Texto para Nome.")

                    VerticalSpacer(height = 8)

                    NameInputText(onSearch = {}, state = style)

                    VerticalSpacer(height = 16)

                    LabelLargeText(text = "Input de Texto para Senha.")

                    VerticalSpacer(height = 8)

                    PasswordInputText(onSearch = {})

                    VerticalSpacer(height = 16)

                    LabelLargeText(text = "Input de Texto para Celular.")

                    VerticalSpacer(height = 8)

                    PhoneInputText(onSearch = {}, state = style)

                    VerticalSpacer(height = 16)

                    LabelLargeText(text = "Input de Texto que aceita apenas Letras.")

                    VerticalSpacer(height = 8)

                    OnlyLettersInputText(maxLength = 60, onSearch = {}, state = style)

                    VerticalSpacer(height = 16)

                    LabelLargeText(text = "Input de Texto que aceita apenas Numeros.")

                    VerticalSpacer(height = 8)

                    OnlyNumbersInputText(maxLength = 10, onSearch = {}, state = style)

                    VerticalSpacer(height = 16)

                    LabelLargeText(text = "Input de Texto basico, sem validações.")

                    VerticalSpacer(height = 8)

                    BasicInputText(maxLength = 100, onSearch = {}, state = style)

                }
            }

        })
}