package br.com.vtvinicius.uikit.ui.newTextField

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.blueCanvasDark
import br.com.vtvinicius.uikit.base.red
import br.com.vtvinicius.uikit.base.white
import com.google.android.material.tooltip.TooltipDrawable

enum class ValidationEnum {
    SUCCESS, ERROR, NORMAL, NO_VALIDATION
}

@Composable
fun BaseTextField2(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {},
    validation: (String) -> ValidationEnum = { ValidationEnum.NORMAL },
    label: String = "Campo de Texto",
    singleLine: Boolean = true,
    maxLines: Int = 1,
    errorIcon: Int = R.drawable.ic_error_alert,
    successIcon: Int = R.drawable.baseline_done_24,
    startValidation: Boolean = false,
    isPassword: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    mask: VisualTransformation? = null,
    trailingText: String = "",
    isMandatory: Boolean = true,
    infoText: String = ""
) {

    var isError by rememberSaveable { mutableStateOf(false) }

    var isSuccess by rememberSaveable { mutableStateOf(false) }

    var isNormal by rememberSaveable { mutableStateOf(false) }

    var isNoValidation by rememberSaveable { mutableStateOf(false) }

    var textFieldValue by remember {
        mutableStateOf(
            TextFieldValue(
                text = "", selection = TextRange(0)
            )
        )

    }

    var eyeClosed by remember {
        mutableStateOf(true)
    }

    var showInfo by remember {
        mutableStateOf(false)
    }

    val interactionSource = remember { MutableInteractionSource() }


    fun checkValidation(text: String) {
        isError = validation(text) == ValidationEnum.ERROR
        isSuccess = validation(text) == ValidationEnum.SUCCESS
        isNormal = validation(text) == ValidationEnum.NORMAL
        isNoValidation = validation(text) == ValidationEnum.NO_VALIDATION

    }

    if (startValidation) {
        checkValidation(textFieldValue.text)
    }

        Column(modifier.zIndex(0f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {

               TooltipContent(modifier = modifier, tooltipsText = infoText, name = label, isMandatory = isMandatory)


            }


            TextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    if (isNoValidation) {
                        onSearch(newValue.text)
                        isNormal = false
                        isError = false
                        isSuccess = false
                    }
                    if (textFieldValue.text != newValue.text) { // Verifica se o texto realmente mudou
                        textFieldValue = newValue //
                        isError = false
                        isSuccess = false
                    }
                    if (isSuccess) {
                        onSearch(newValue.text)
                    }

                },
                visualTransformation =
                mask ?: if (isPassword) {
                    if (eyeClosed) {

                        PasswordVisualTransformation()
                    } else {
                        VisualTransformation.None
                    }
                } else {
                    VisualTransformation.None
                },
                shape = RoundedCornerShape(8.dp),
                modifier = modifier
                    .border(
                        1.dp,
                        if (isError) red else Color(0xFFD2D4DA),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xFF595C61),
                    backgroundColor = white,
                    cursorColor = Color(0xFF595C61),
                    disabledLabelColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    errorTrailingIconColor = red
                ),
                trailingIcon = {
                    if (trailingText.isNotEmpty()) {
                        Text(text = trailingText)
                    } else {
                        if (isPassword) {
                            IconButton(onClick = {
                                eyeClosed = !eyeClosed
                            }) {
                                Icon(
                                    painter = painterResource(id = if (eyeClosed) R.drawable.ic_eye_closed else R.drawable.ic_eye_open),
                                    contentDescription = "visibility Icon",
                                    modifier = Modifier.size(15.dp)
                                )
                            }

                        } else {
                            if (isError) {
                                Icon(
                                    painter = painterResource(id = errorIcon),
                                    modifier = Modifier.size(20.dp),
                                    contentDescription = null
                                )
                            } else if (isSuccess) {
                                Icon(
                                    painter = painterResource(id = successIcon),
                                    modifier = Modifier.size(20.dp),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                },
                keyboardOptions = keyboardOptions,
                maxLines = maxLines,
                singleLine = singleLine,
                isError = isError,
                interactionSource = interactionSource
            )
        }
}


@Composable
fun CustomTextLabel(label: String, isMandatory: Boolean) {
    val annotatedText = buildAnnotatedString {
        // Parte do texto com a cor azul
        append(label)
        addStyle(style = SpanStyle(color = blueCanvasDark), start = 0, end = label.length)

        // Se for obrigatório, adicione "*" com a cor vermelha
        if (isMandatory) {
            val start = length
            append(" *")
            addStyle(style = SpanStyle(color = Color.Red), start = start, end = length)
        }
    }

    Row {
        Text(text = annotatedText)
    }
}




@Composable
fun InfoCard(infoText: String, modifier: Modifier = Modifier) {

    Card(
        backgroundColor = white,
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .defaultMinSize(minHeight = 100.dp)
            .width(200.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = infoText)
        }
    }
}