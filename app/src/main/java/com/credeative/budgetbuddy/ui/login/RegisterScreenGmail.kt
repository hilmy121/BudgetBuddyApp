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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.ui.theme.Typography
import com.credeative.budgetbuddy.ui.theme.theme_light_primary_container
import com.credeative.budgetbuddy.ui.theme.theme_light_primary_container_border
import com.credeative.budgetbuddy.ui.theme.unchecked_checkbox


@Composable
fun RegisterScreenGmailUI(modifier: Modifier = Modifier){
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
                .fillMaxWidth(0.9F)
                .padding(start = 10.dp, end = 10.dp, top = 20.dp)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
            Spacer(modifier = modifier
                .fillMaxWidth()
                .height(20.dp))
            Text(text = "Daftar Akun", style = Typography.displaySmall, modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(bottom = 5.dp), maxLines = 2)
            Text(text = "Pastikan email yang kamu masukan aktif terus ya. ", style = Typography.bodySmall, modifier = Modifier.fillMaxWidth(), maxLines = 2)
            Spacer(modifier = modifier
                .fillMaxWidth()
                .height(35.dp))
            RegisterForm(
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
                .weight(0.1f))

            Box(modifier = Modifier.fillMaxWidth()){
                Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier.align(
                    Alignment.CenterStart)){
                    Checkbox(checked = false, onCheckedChange = {},modifier = Modifier.size(50.dp), colors = CheckboxDefaults.colors(
                        uncheckedColor = unchecked_checkbox

                    ))
                    Text(text = "Dengan mendaftar, Anda menyetujui Ketentuan Layanan dan Kebijakan Privasi.", style = Typography.bodySmall, maxLines = 2)
                }
            }

            Spacer(modifier = modifier
                .fillMaxWidth()
                .weight(0.1f))
            Card (modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), shape = RoundedCornerShape(10.dp), border = BorderStroke(width = 1.dp, color = theme_light_primary_container_border), colors = CardDefaults.cardColors(containerColor = theme_light_primary_container)){
                Box(modifier = Modifier.fillMaxSize()){
                    Text(text = "Daftar", color = Color.White, modifier = Modifier.align(Alignment.Center))
                }
            }
            Spacer(modifier = modifier
                .fillMaxWidth()
                .height(40.dp))
            Box(modifier = Modifier.fillMaxWidth()){
                Text(text = "Masuk atau Mendaftar dengan Gmail kamu",modifier = Modifier.align(
                    Alignment.Center))
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))
            Card (modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), shape = RoundedCornerShape(10.dp), border = BorderStroke(width = 1.dp, color = theme_light_primary_container_border), colors = CardDefaults.cardColors(containerColor = Color.White)){
                Box(modifier = Modifier.fillMaxSize()){
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){

                        Text(text = "Masuk dengan Gmail") }
                }
            }
            Spacer(modifier = modifier
                .fillMaxWidth()
                .weight(0.3f))
        }
    }
}
@Composable
fun RegisterFormGmail(modifier: Modifier = Modifier,
                      onNameValueChange:(String)->Unit,
                      onEmailValueChange:(String)->Unit,
                      nameValue:String,
                      emailValue:String,
                      focusRequester: FocusRequester? = null,
                      keyboardActionsName: KeyboardActions,
                      keyboardActionsEmail: KeyboardActions
) {
    Column (modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)){
        Text(text = "Nama")
        AccountFormTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onValueChange = onNameValueChange,
            value = nameValue,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = keyboardActionsName
        )
        Text(text = "Email Aktif")
        AccountFormTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onValueChange = onEmailValueChange,
            focusRequester = focusRequester,
            value = emailValue,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done),
            keyboardActions = keyboardActionsEmail
        )
        Text(text = "Password")
        AccountFormTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onValueChange = onEmailValueChange,
            focusRequester = focusRequester,
            value = emailValue,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done),
            keyboardActions = keyboardActionsEmail
        )
        Text(text = "Konfirmasi Password")
        AccountFormTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onValueChange = onEmailValueChange,
            focusRequester = focusRequester,
            value = emailValue,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done),
            keyboardActions = keyboardActionsEmail
        )




    }
}
