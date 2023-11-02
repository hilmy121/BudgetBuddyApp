package com.credeative.budgetbuddy.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(0.2f))
            Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = "Halo Buddy")
                Text(text = "Selamat Datang")
            }
            Spacer(modifier = Modifier.weight(0.8f))
            Image(painter = painterResource(id = R.drawable.ic_hero_budget_buddy_20), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}
