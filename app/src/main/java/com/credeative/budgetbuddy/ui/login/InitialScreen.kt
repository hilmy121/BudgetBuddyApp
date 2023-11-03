package com.credeative.budgetbuddy.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.ui.theme.Shape

@Composable
fun InitialScreenUI(modifier:Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize(0.9f)
                .padding(start = 10.dp, end = 10.dp, top = 20.dp)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Top) {

            Text(text = "Eh, Kamu orang baru ya?")
            Text(text = "Eh, Kamu orang baru ya?")
            IncomeInput()



        }
    }
}

@Composable
fun IncomeInput(modifier: Modifier = Modifier){
    Column (modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center){
        Text(text = "Nama Kamu")
        Surface (modifier= modifier
            .fillMaxWidth()
            .height(40.dp), shape = Shape.small){

        }
        Text(text = "Nama Kamu")
        Surface (modifier= modifier
            .fillMaxWidth()
            .height(40.dp), shape = Shape.small){

        }
        Text(text = "Nama Kamu")
        Surface (modifier= modifier
            .fillMaxWidth()
            .height(40.dp), shape = Shape.small){

        }

    }
}

@Preview(showBackground = true)
@Composable
fun InitialScreenUIPreview(){
    InitialScreenUI()
}