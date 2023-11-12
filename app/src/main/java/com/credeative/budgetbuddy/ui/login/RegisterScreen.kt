package com.credeative.budgetbuddy.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.ui.theme.SecondaryCardColor
import com.credeative.budgetbuddy.ui.theme.Shape
import com.credeative.budgetbuddy.ui.theme.TertiaryBorderColor
import com.credeative.budgetbuddy.ui.theme.Typography


@Composable
fun RegisterUI(modifier:Modifier = Modifier){
    val nameFocusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    var name by rememberSaveable {
        mutableStateOf("")
    }
    var email by rememberSaveable {
        mutableStateOf("")
    }
    Box(modifier = modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize(0.9f)
                .padding(start = 10.dp, end = 10.dp, top = 20.dp)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Top) {
            Spacer(modifier = modifier
                .fillMaxWidth()
                .height(20.dp))
            Text(text = "Eh, Kamu orang baru ya?", style = Typography.displaySmall, modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(bottom = 5.dp), maxLines = 2)
            Text(text = "Sebelum melanjutkan, silahkan konfirmasi Nama dan email kamu yang terdaftar", style = Typography.bodySmall, modifier = Modifier.fillMaxWidth(), maxLines = 2)
            Spacer(modifier = modifier
                .fillMaxWidth()
                .height(50.dp))
            AccountInput(
                nameValue = name,
                emailValue = email,
                modifier = Modifier.fillMaxWidth(),
                onNameValueChange = { name = it },
                onEmailValueChange = { email = it },
                keyboardActionsName = KeyboardActions(onNext = {
                    nameFocusRequester.requestFocus()
                }),
                keyboardActionsEmail = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
                focusRequester = nameFocusRequester
                )
            Spacer(modifier = modifier
                .fillMaxWidth()
                .weight(0.6f))
            Column ( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(15.dp)){
                Surface(modifier = Modifier.fillMaxWidth(0.85f), shape = RoundedCornerShape(10.dp), shadowElevation = 5.dp, color = SecondaryCardColor,
                    border = BorderStroke(1.dp, TertiaryBorderColor)
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){

                        Text(text = "Semua Sudah okee!", color = Color.White)

                    }
                }
            }
            Spacer(modifier = modifier
                .fillMaxWidth()
                .height(40.dp))
            Column ( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(15.dp)){
                Text(text = "Masuk atau Mendaftar dengan Gmail kamu")
                Surface(modifier = Modifier.fillMaxWidth(0.85f), shape = RoundedCornerShape(10.dp), shadowElevation = 5.dp
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){

                        Text(text = "Masuk dengan Gmail")

                    }
                }
            }
            Spacer(modifier = modifier
                .fillMaxWidth()
                .weight(0.3f))
        }
    }
}

@Composable
fun AccountInput(modifier: Modifier = Modifier,
                 onNameValueChange:(String)->Unit,
                 onEmailValueChange:(String)->Unit,
                 nameValue:String,
                 emailValue:String,
                 focusRequester: FocusRequester? = null,
                 keyboardActionsName: KeyboardActions,
                 keyboardActionsEmail: KeyboardActions) {
    Column (modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)){
        Text(text = "Nama Kamu")
        AccountTextField(
            modifier = Modifier.fillMaxWidth(),
            onValueChange = onNameValueChange,
            value = nameValue,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = keyboardActionsName
        )
        Text(text = "Email Kamu")
        AccountTextField(
            modifier = Modifier.fillMaxWidth(),
            onValueChange = onEmailValueChange,
            focusRequester = focusRequester,
            value = emailValue,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done),
            keyboardActions = keyboardActionsEmail
        )


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountTextField(
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutTextField(modifier:Modifier = Modifier){
    OutlinedTextField(modifier = modifier
        .fillMaxWidth(0.8f)
        .height(50.dp),
        value = "",
        onValueChange = {},
        singleLine = true,
        shape = Shape.extraSmall,
        colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White))
}

@Preview(showBackground = true)
@Composable
fun RegisterUIPreview(){
    RegisterUI()
}

@Preview(showBackground = true)
@Composable
fun AccountInputPreview(){
    OutTextField()
}


