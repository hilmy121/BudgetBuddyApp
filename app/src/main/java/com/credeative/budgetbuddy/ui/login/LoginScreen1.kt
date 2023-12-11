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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.ui.theme.theme_light_onSecondary
import com.credeative.budgetbuddy.ui.theme.theme_light_onTertiary
import com.credeative.budgetbuddy.ui.theme.theme_light_primary_container
import com.credeative.budgetbuddy.ui.theme.theme_light_primary_container_border
import com.credeative.budgetbuddy.ui.theme.theme_light_secondary_container
import com.credeative.budgetbuddy.ui.theme.theme_light_secondary_container_border

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

                Card(modifier = Modifier.fillMaxWidth(0.9f), shape = RoundedCornerShape(10.dp), border = BorderStroke(width = 2.dp, color = theme_light_primary_container_border), colors = CardDefaults.cardColors(containerColor = theme_light_primary_container)) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)){
                        Text(modifier = Modifier.align(Alignment.Center), text = "Akun Baru", color = Color.White)
                    }
                }
                Card(modifier = Modifier.fillMaxWidth(0.9f), shape = RoundedCornerShape(10.dp), border = BorderStroke(width = 2.dp, color = theme_light_secondary_container), colors = CardDefaults.cardColors(containerColor = theme_light_secondary_container_border)) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)){
                        Text(modifier = Modifier.align(Alignment.Center), text = "Masuk", color = Color.White)
                    }
                }
                Spacer(modifier = Modifier.fillMaxWidth().weight(0.2f))
                Text(text = "Masuk atau Mendaftar dengan Gmail kamu", color = theme_light_onSecondary)
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

                        Text(text = "Masuk dengan Gmail", color = theme_light_onTertiary)

                    }
                }
                Spacer(modifier = Modifier.fillMaxWidth().weight(0.1f))
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
