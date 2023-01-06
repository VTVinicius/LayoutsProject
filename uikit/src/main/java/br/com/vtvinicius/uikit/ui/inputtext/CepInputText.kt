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

@Composable
fun CepInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.OUTLINE,
    onSearch: (String) -> Unit
) {
    val styleType: InputTextStyleType = remember { InputTextStyleType.CEP }

    val error = remember { mutableStateOf(false) }

    var currentState: InputTextState = state

    currentState.getPasswordIcon(null)

    when (error.value) {
        true -> {
            currentState = InputTextState.ERROR
            styleType.getErrorMessage("CEP incompleto")
        }
        else -> {
            currentState = state
            styleType.getErrorMessage("")
        }
    }

    BaseInputText(
        modifier = modifier,
        hint = "CEP",
        state = currentState,
        mask = Mask.buildCEP(),
        maxLength = 8,
        styleType = styleType,
        inputType = RegexEnum.NUMBERS,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = {
            when (it.length < 8) {
                true -> {
                    error.value = true
                }
                false -> {
                    error.value = false
                }
            }
            onSearch(it)
        }
    )
}
