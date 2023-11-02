package com.credeative.budgetbuddy.ui.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.R

@Composable
fun LoginScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            Modifier
                .align(Alignment.Center)
                .fillMaxSize()
                .padding(horizontal = 10.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround) {
            Spacer(modifier = Modifier.weight(0.2f))
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Halo Buddy")
                Text(text = "Selamat Datang")
            }
            Spacer(modifier = Modifier.weight(0.8f))
            Image(painter = painterResource(id = R.drawable.ic_hero_budget_buddy_20), contentDescription = null)
            Spacer(modifier = Modifier.weight(0.6f))
            Column (modifier = Modifier.fillMaxWidth(0.9f), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(15.dp)){
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
            Spacer(modifier = Modifier.weight(0.55f))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}
