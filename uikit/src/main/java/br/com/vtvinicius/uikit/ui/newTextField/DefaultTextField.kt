package br.com.vtvinicius.uikit.ui.newTextField

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

@Composable
fun DefaultTextField(
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
        infoText = "Por que pedimos o seu CPF?\n" +
                "\n" +
                " Texto explicativo da empresa sobre como será o uso do CPF do cliente no aplicativo. No máximo quatro linhas para esta breve explicação Texto explicativo da empresa sobre como será o uso do CPF do cliente no aplicativo. No máximo quatro linhas para esta breve explicação"
        ,
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