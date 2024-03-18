package com.credeative.budgetbuddy.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.ui.theme.Shape

@Composable
fun LoginDialog(errorMessage:String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(2.dp),
        shape = Shape.extraSmall,
        colors = CardDefaults.cardColors(containerColor = Color(0xFFBD0606)),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 5.dp), horizontalArrangement = Arrangement.Center){
//            Icon(painter = , contentDescription = )
            Text(text = errorMessage, maxLines = 2, color = Color.White)
        }
    }
}