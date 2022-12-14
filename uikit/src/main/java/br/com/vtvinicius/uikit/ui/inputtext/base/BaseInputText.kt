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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.vtvinicius.uikit.base.ApplicationTheme
import br.com.vtvinicius.uikit.ui.text.BodySmallText


@Composable
fun BaseInputText(
    modifier: Modifier = Modifier,
    hint: String = "",
    mask: VisualTransformation? = null,
    maxLength: Int? = null,
    state: InputTextState = InputTextState.NORMAL,
    onSearch: (String) -> Unit = {},
    onIconClick: () -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
) {

    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    var isFieldEmpty by remember {
        mutableStateOf(true)
    }

    Column {
        Box(
            modifier = modifier
        ) {
            TextField(
                value = text,
                onValueChange = {
                    if (it.length > (maxLength ?: 0)) {
                        return@TextField
                    } else if (it.length < text.length) {
                        text = it
                        isFieldEmpty = it == ""
                    } else {
                        text = it
                        onSearch(it)
                        isFieldEmpty = it == ""
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
                                contentDescription = "visibility Icon"
                            )
                        }
                    } else {
                        onIconClick()
                    }
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = keyboardOptions,
                textStyle = TextStyle(color = Color.Black, fontSize = 12.sp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = state.getBackgroundColor(),
                    cursorColor = Color.Black,
                    disabledLabelColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = ApplicationTheme.dimensions.defaultSize,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
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
                    BodySmallText(text = hint, Color.Gray, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}


