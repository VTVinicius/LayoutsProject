package br.com.vtvinicius.uikit.ui.newTextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun NormalTextField(
    text: (String) -> Unit = {},
    isSuccess: (Boolean) -> Unit = {},
) {


    val isValidation by remember {
        mutableStateOf(false)
    }

    BaseTextField2(startValidation = true, validation = {
        ValidationEnum.NO_VALIDATION
    }, onSearch = {
        if (isValidation) {
            isSuccess(true)
            text(it)
        } else {
            text(it)
        }
    })

}