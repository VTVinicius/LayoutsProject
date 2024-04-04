package br.com.vtvinicius.uikit.ui.newTextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import br.com.vtvinicius.uikit.R
import kotlinx.coroutines.delay

@Composable
fun NewCPFTextField(
    text: (String) -> Unit = {},
    isSuccess: (Boolean) -> Unit = {},
    validationBoolean: Boolean
) {

        var validation by remember {
            mutableStateOf(validationBoolean)
        }

        val isValidation by remember {
            mutableStateOf(true)
        }

        LaunchedEffect(key1 = validationBoolean) {
            validation = true
            delay(100)
            validation = false
        }


        BaseTextField2(
            label = "CPF",
            infoText = buildString {
                append(stringResource(R.string.por_que_pedimos_o_seu_cpf))
                append("\n")
                append(stringResource(R.string.texto_explicativo_da_empresa))
            },
            startValidation = validation, validation = {
                when {
                    it.length != 8 && it.isNotEmpty() -> {
                        isSuccess(false)
                        ValidationEnum.ERROR
                    }
                    it.length == 8 -> {
                        isSuccess(true)
                        ValidationEnum.SUCCESS

                    }
                    it.isEmpty() -> {
                        isSuccess(false)
                        ValidationEnum.NORMAL
                    }
                    else -> ValidationEnum.NORMAL
                }
            }, onSearch = {
                if (isValidation) {
                    isSuccess(true)
                    text(it)
                } else {
                    text(it)
                }
            })

    }
