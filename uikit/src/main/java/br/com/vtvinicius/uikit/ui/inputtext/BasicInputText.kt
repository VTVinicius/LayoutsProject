package br.com.vtvinicius.uikit.ui.inputtext

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import br.com.vtvinicius.uikit.ui.inputtext.base.BaseInputText
import br.com.vtvinicius.uikit.ui.inputtext.base.InputTextState

@Composable
fun BasicInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.NORMAL,
    hint: String = "",
    maxLength: Int,
    onSearch: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    BaseInputText(
        modifier = modifier,
        hint = hint,
        state = state,
        mask = VisualTransformation.None,
        maxLength = maxLength,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        onSearch = onSearch
    )
}
