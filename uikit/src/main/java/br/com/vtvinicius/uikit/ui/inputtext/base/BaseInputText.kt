package br.com.vtvinicius.uikit.ui.inputtext.base

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.ApplicationTheme
import br.com.vtvinicius.uikit.base.gray
import br.com.vtvinicius.uikit.base.red
import br.com.vtvinicius.uikit.ui.inputtext.utils.RegexEnum
import br.com.vtvinicius.uikit.ui.inputtext.utils.unmask
import br.com.vtvinicius.uikit.ui.text.BodyMediumText
import br.com.vtvinicius.uikit.ui.text.LabelSmallText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import java.text.NumberFormat
import java.util.*


@Composable
fun BaseInputText(
    modifier: Modifier = Modifier,
    hint: String = "",
    mask: VisualTransformation? = null,
    maxLength: Int? = null,
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit = {},
    onIconClick: () -> Unit = {},
    isMoney: Boolean = false,
    inputType: RegexEnum? = null,
    styleType: InputTextStyleType = InputTextStyleType.NOTHING,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
) {

    val LOCALE_PT_BR = Locale("pt", "BR")

    val mFormatter: NumberFormat = NumberFormat.getCurrencyInstance(LOCALE_PT_BR)

    var mIsUpdating: Boolean = false

    var text by remember {
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    var isFieldEmpty by remember {
        mutableStateOf(true)
    }

    val textFieldValue = remember {
        mutableStateOf(
            TextFieldValue(
                text = text,
                selection = TextRange(0)
            )
        )

    }

    Column {
        Box(
            modifier = modifier
        ) {
            TextField(
                value = textFieldValue.value,
                onValueChange = {
                    if (isMoney) {
                        if (!mIsUpdating && it.text.unmask()
                                .matches(inputType?.value ?: RegexEnum.ALL.value)
                        ) {
                            mIsUpdating = true
                            val cleanString = it.text.unmask()
                            val parsed = cleanString.toDouble()
                            val formatted = mFormatter.format(parsed / 100)
                            text = formatted
                            mIsUpdating = false

                            textFieldValue.value = TextFieldValue(
                                text = text,
                                selection = TextRange(text.length)
                            )
                            isFieldEmpty = it.text == ""
                        }
                    } else {
                        if (it.text.length > (maxLength ?: 0)) {
                            return@TextField
                        } else if (it.text.matches(inputType?.value ?: RegexEnum.ALL.value)) {
                            textFieldValue.value = it
                            onSearch(it.text)
                            isFieldEmpty = it.text == ""
                        } else if (it.text.length < textFieldValue.value.text.length) {
                            textFieldValue.value = it
                            isFieldEmpty = it.text == ""
                        }
                    }

                },
                visualTransformation =
                if (mask != null && mask is PasswordVisualTransformation) {
                    PasswordVisualTransformation()
                } else mask ?: VisualTransformation.None,
                trailingIcon =
                {
                    if (state.rightIcon != null) {
                        IconButton(
                            onClick = {
                                onIconClick()
                            }
                        ) {

                            Icon(
                                painter = painterResource(id = state.rightIcon!!),
                                contentDescription = "visibility Icon",
                                modifier = Modifier
                                    .size(15.dp)
                            )
                        }
                    } else {
                        onIconClick()
                    }
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = keyboardOptions,
                textStyle = TextStyle(color = Color.Black),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = state.getBackgroundColor(),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = ApplicationTheme.dimensions.defaultSize,
                modifier = modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .border(
                        width = state.getBorderSize(),
                        color = state.getBorderColor(),
                        shape = ApplicationTheme.dimensions.defaultSize,
                    )
                    .background(
                        state.getBackgroundColor(),
                        ApplicationTheme.dimensions.defaultSize
                    )
                    .onFocusChanged {
                        if (isFieldEmpty) {
                            isHintDisplayed = it.isFocused != true
                        } else {
                            isHintDisplayed = false
                        }
                    },

                )
            if (isHintDisplayed) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                ) {
                    BodyMediumText(
                        modifier = modifier,
                        align = TextAlign.Center,
                        text = hint,
                        colors = gray
                    )
                }
            }
        }

        VerticalSpacer(height = 2)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (styleType.errorMessage != "") {
                Icon(
                    painter = painterResource(id = R.drawable.ic_error_alert),
                    tint = red,
                    modifier = Modifier.size(16.dp),
                    contentDescription = "Error Icon"
                )

                HorizontalSpacer(width = 4)

                LabelSmallText(
                    text = styleType.errorMessage,
                    colors = red,
                    align = TextAlign.Start

                )
            }
        }
    }

}

