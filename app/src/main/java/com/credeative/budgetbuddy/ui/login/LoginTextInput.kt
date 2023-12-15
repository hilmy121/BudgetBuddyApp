package com.credeative.budgetbuddy.ui.login

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.ui.theme.Shape


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountFormTextField(
    modifier:Modifier = Modifier,
    onValueChange:(String)->Unit,
    value:String,
    focusRequester: FocusRequester? = null,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions){
    OutlinedTextField(
        modifier=modifier.height(50.dp).focusProperties { focusRequester ?: FocusRequester() },
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        shape = Shape.extraSmall,
        colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions)
//    TextField(
//        value = value,
//        onValueChange = onValueChange,
//        modifier = modifier
//            .focusProperties { focusRequester ?: FocusRequester() }
//            .fillMaxWidth(0.8f),
//        singleLine = true,
//        shape = Shape.small, colors = TextFieldDefaults.textFieldColors(containerColor = Color.White))

}