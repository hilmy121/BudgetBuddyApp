package com.credeative.budgetbuddy.ui.account

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.ui.theme.BlackBorderStrokeColor
import com.credeative.budgetbuddy.ui.theme.GreyBorderStrokeColor
import com.credeative.budgetbuddy.ui.theme.Shape

@Composable
fun AccountUI(){

    Column {
        Card(modifier = Modifier.fillMaxWidth(), shape = Shape.extraSmall, border = BorderStroke(0.5.dp, GreyBorderStrokeColor)){
            Text(text = "Tentang Kami")
        }
        Card(modifier = Modifier.fillMaxWidth(), shape = Shape.extraSmall, border = BorderStroke(0.5.dp, GreyBorderStrokeColor)){
            Text(text = "Singkron Data Sekarang")
        }
        Card(modifier = Modifier.fillMaxWidth(), shape = Shape.extraSmall, border = BorderStroke(0.5.dp, GreyBorderStrokeColor)){
            Text(text = "Keluar")
        }
    }
}
@Composable
fun UserInformation(modifier: Modifier = Modifier){
    Card(modifier = modifier
        .fillMaxWidth()
        .height(100.dp), shape = Shape.small, border = BorderStroke(0.5.dp, BlackBorderStrokeColor)){
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.weight(0.5f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "Nama")
                    Text(text = "Email")
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }

    }
}
@Preview(showBackground = true)
@Composable
fun AccountUIPreview(){
    UserInformation()
}
