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
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.ui.theme.SecondaryCardColor
import com.credeative.budgetbuddy.ui.theme.Shape
import com.credeative.budgetbuddy.ui.theme.TertiaryBorderColor
import com.credeative.budgetbuddy.ui.theme.Typography

@Composable
fun InitialScreenUI(modifier:Modifier = Modifier){
    val incomeFocusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    var name by rememberSaveable {
        mutableStateOf("")
    }
    var income by rememberSaveable {
        mutableStateOf("")
    }
    var date by rememberSaveable {
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
            IncomeInput(
                nameValue = name,
                incomeValue = income,
                dateValue = date,
                modifier = Modifier.fillMaxWidth(),
                onNameValueChange = {
                    name = it
                },
                onIncomeValueChange = {
                    income = it
                },
                onDateValueChange ={
                    date = it
                },
                keyboardActionsName = KeyboardActions(onNext = {
                    incomeFocusRequester.requestFocus()
                }),
                keyboardActionsIncome = KeyboardActions(onNext = {
                    focusManager.clearFocus()
                    incomeFocusRequester.requestFocus()
                }),
                keyboardActionsDate = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }), focusRequester = incomeFocusRequester
            )

            Spacer(modifier = modifier
                .fillMaxWidth()
                .height(20.dp))

            Surface(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(5.dp), shadowElevation = 5.dp, color = Color.Gray
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center){

                    Text(text = "Kamu bisa menambahkan pendapatan mu nanti", maxLines = 2, textAlign = TextAlign.Start)

                }
            }

            Spacer(modifier = modifier
                .fillMaxWidth()
                .weight(0.6f))

            Column ( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(15.dp)){
                Surface(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10.dp), shadowElevation = 5.dp, color = SecondaryCardColor
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){

                        Text(text = "Simpan", color = Color.White)

                    }
                }
            }
            Spacer(modifier = modifier
                .fillMaxWidth()
                .height(40.dp))

        }
    }
}

@Composable
fun IncomeInput(modifier: Modifier = Modifier,
                onNameValueChange:(String)->Unit,
                onIncomeValueChange:(String)->Unit,
                onDateValueChange:(String)->Unit,
                nameValue:String,
                incomeValue:String,
                dateValue:String,
                focusRequester: FocusRequester? = null,
                keyboardActionsName: KeyboardActions,
                keyboardActionsIncome: KeyboardActions,
                keyboardActionsDate:KeyboardActions) {
    Column (modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)){
        Text(text = "Nama Pemasukan")
        IncomeTextField(
            modifier = Modifier.fillMaxWidth(),
            onValueChange = onNameValueChange,
            value = nameValue,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = keyboardActionsName)
        Text(text = "Pendapatan Bulanan")
        IncomeTextField(
            modifier = Modifier.fillMaxWidth(),
            onValueChange = onIncomeValueChange,
            value = incomeValue,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
            keyboardActions = keyboardActionsIncome)
        Text(text = "Dibayarkan setiap tanggal")
        IncomeTextField(
            modifier = Modifier.fillMaxWidth(),
            onValueChange = onDateValueChange,
            value = dateValue,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number),
            keyboardActions = keyboardActionsDate,
            focusRequester = focusRequester)


    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomeTextField(
    modifier:Modifier = Modifier,
    onValueChange:(String)->Unit,
    value:String,
    focusRequester: FocusRequester? = null,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions){
    OutlinedTextField(
        modifier= modifier
            .height(50.dp)
            .focusProperties { focusRequester ?: FocusRequester() },
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        shape = Shape.extraSmall,
        colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.White),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions)

}

@Preview(showBackground = true)
@Composable
fun InitialScreenUIPreview(){
    InitialScreenUI()
}

