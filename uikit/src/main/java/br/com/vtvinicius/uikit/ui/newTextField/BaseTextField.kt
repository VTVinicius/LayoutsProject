package br.com.vtvinicius.uikit.ui.newTextField

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.uikit.R
import br.com.vtvinicius.uikit.base.ApplicationTheme
import br.com.vtvinicius.uikit.base.red
import br.com.vtvinicius.uikit.base.white
import br.com.vtvinicius.uikit.ui.inputtext.base.InputTextStyleType
import br.com.vtvinicius.uikit.ui.inputtext.utils.RegexEnum
import br.com.vtvinicius.uikit.ui.text.BodyMediumText
import br.com.vtvinicius.uikit.ui.text.LabelSmallText
import br.com.vtvinicius.uikit.utils.extensions.HorizontalSpacer
import br.com.vtvinicius.uikit.utils.extensions.VerticalSpacer
import java.text.NumberFormat
import java.util.Locale


@Composable
fun BaseTextField(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {},
    onIconClick: () -> Unit = {},
    icon: Int? = R.drawable.baseline_done_24,
    isIconClickable: Boolean = false,
    inputType: RegexEnum? = null,
    styleType: InputTextStyleType = InputTextStyleType.NOTHING,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    error: Boolean = false,
    errorMessage: String = "erro"
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


    fun validateError() {
        when (error) {
            true -> {
                styleType.getErrorMessage(errorMessage)
            }
            else -> {
                styleType.getErrorMessage("")
            }
        }
    }

    Column {
        Box(
            modifier = modifier
        ) {
            TextField(
                value = textFieldValue.value,
                onValueChange = {
                    if (it.text.length < textFieldValue.value.text.length) {
                        textFieldValue.value = it
                        isFieldEmpty = it.text == ""
                    } else {
                        textFieldValue.value = it
                        onSearch(it.text)


                        validateError()
                    }
                },
                trailingIcon =
                {
                    if (isIconClickable && icon != null ) {
                        IconButton(
                            onClick = {
                                onIconClick()
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = icon),
                                contentDescription = "visibility Icon",
                                modifier = Modifier
                                    .size(15.dp)
                            )
                        }
                    } else if (
                        !isIconClickable && icon != null
                    ){
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = "visibility Icon",
                            modifier = Modifier
                                .size(15.dp)
                        )
                    }
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = keyboardOptions,
                textStyle = TextStyle(color = Color.Black),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xFF595C61),
                    backgroundColor = white,
                    cursorColor = Color(0xFF595C61),
                    disabledLabelColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = ApplicationTheme.dimensions.defaultSize,
                modifier = modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = if(error) Color(0xFFD2D4DA) else red,
                        shape = ApplicationTheme.dimensions.defaultSize,
                    )
                    .background(
                        white,
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
                        colors = Color(0xFF595C61),
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

