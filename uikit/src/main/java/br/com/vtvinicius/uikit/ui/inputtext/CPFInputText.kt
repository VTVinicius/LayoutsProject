import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import br.com.vtvinicius.uikit.ui.inputtext.base.BaseInputText
import br.com.vtvinicius.uikit.ui.inputtext.base.InputTextState
import br.com.vtvinicius.uikit.ui.inputtext.base.InputTextStyleType
import br.com.vtvinicius.uikit.ui.inputtext.utils.Mask
import br.com.vtvinicius.uikit.ui.inputtext.utils.RegexEnum
import br.com.vtvinicius.uikit.ui.inputtext.utils.Validation

@Composable
fun CPFInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit
) {
    val styleType: InputTextStyleType = InputTextStyleType.CPF

    val error = remember { mutableStateOf(false) }

    var currentState: InputTextState = state

    currentState.getPasswordIcon(null)

    when (error.value) {
        true -> {
            currentState = InputTextState.ERROR
            styleType.getErrorMessage("CPF inválido")
        }
        else -> {
            currentState = state
            styleType.getErrorMessage("")
        }
    }

    BaseInputText(
        modifier = modifier,
        hint = "CPF",
        state = currentState,
        mask = Mask.buildCpf(),
        maxLength = 11,
        styleType = styleType,
        inputType = RegexEnum.NUMBERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = {
            onSearch(it)
            when (Validation().validateCPF(it)) {
                true -> {
                    error.value = false
                }
                false -> {
                    error.value = true
                }
            }
        }
    )
}
