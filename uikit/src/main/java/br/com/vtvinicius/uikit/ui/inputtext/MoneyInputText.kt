import android.widget.EditText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import br.com.vtvinicius.uikit.ui.inputtext.base.BaseInputText
import br.com.vtvinicius.uikit.ui.inputtext.base.InputTextState
import br.com.vtvinicius.uikit.ui.inputtext.base.InputTextStyleType
import br.com.vtvinicius.uikit.ui.inputtext.utils.RegexEnum
import java.text.NumberFormat
import java.util.*

@Composable
fun MoneyInputText(
    modifier: Modifier = Modifier,
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit,
) {

    val styleType: InputTextStyleType = InputTextStyleType.NOTHING

    val error = remember { mutableStateOf(false) }

    var currentState: InputTextState = state

    currentState.getPasswordIcon(null)

    when (error.value) {
        true -> {
            currentState = InputTextState.ERROR
            styleType.getErrorMessage("")
        }
        else -> {
            currentState = state
            styleType.getErrorMessage("")
        }
    }

    BaseInputText(
        modifier = modifier,
        hint = "Dinheiro",
        state = currentState,
        maxLength = 69,
        styleType = styleType,
        inputType = RegexEnum.NUMBERS,
        mask = VisualTransformation.None,
        isMoney = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        onSearch = {
            onSearch(it)
        }
    )
}