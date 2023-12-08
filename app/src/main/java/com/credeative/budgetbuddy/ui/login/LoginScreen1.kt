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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            Modifier
                .align(Alignment.Center)
                .fillMaxSize()
                .padding(horizontal = 10.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround) {

            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(15.dp)){
                ViewpagerApp(modifier = Modifier.fillMaxWidth())

                Card(modifier = Modifier.fillMaxWidth(0.9f), shape = RoundedCornerShape(10.dp), border = BorderStroke(width = 1.dp, color = Color.White), colors = CardDefaults.cardColors(containerColor = Color.Blue)) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)){
                        Text(modifier = Modifier.align(Alignment.Center), text = "Akun Baru", color = Color.White)
                    }
                }
                Card(modifier = Modifier.fillMaxWidth(0.9f), shape = RoundedCornerShape(10.dp), border = BorderStroke(width = 1.dp, color = Color.White), colors = CardDefaults.cardColors(containerColor = Color.Blue)) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp)){
                        Text(modifier = Modifier.align(Alignment.Center), text = "Masuk", color = Color.White)
                    }
                }

                Text(text = "Masuk atau Mendaftar dengan Gmail kamu")
                Card(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(width = 1.dp, color = Color.White),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){

                        Text(text = "Masuk dengan Gmail", color = Color.Cyan)

                    }
                }
//                Surface(modifier = Modifier.fillMaxWidth(0.85f), shape = RoundedCornerShape(10.dp), shadowElevation = 5.dp
//                ) {
//                    Row (
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(50.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.Center){
//
//                        Text(text = "Masuk dengan Gmail")
//
//                    }
//                }
            }
            Spacer(modifier = Modifier.weight(0.55f))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}
