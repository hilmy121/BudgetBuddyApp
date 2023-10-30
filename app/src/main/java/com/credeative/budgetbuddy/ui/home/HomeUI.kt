package com.credeative.budgetbuddy.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
import com.credeative.budgetbuddy.ui.theme.PrimaryColorContainer
import com.credeative.budgetbuddy.ui.theme.Shape
import com.credeative.budgetbuddy.ui.theme.Typography

@Composable
fun HomeUi(){

}

@Composable
fun TopUi(){
    FundInformation(modifier = Modifier.fillMaxWidth())
}
@Composable
fun AccountInformation(){

}
@Composable
fun FundOption(modifier: Modifier = Modifier){
    Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(modifier = Modifier.size(height = 50.dp, width = 75.dp), border = BorderStroke(0.5.dp,Color.Gray), shape = Shape.extraSmall) {

            }
            Text(text = "Text")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(modifier = Modifier.size(height = 50.dp, width = 75.dp), border = BorderStroke(0.5.dp,Color.Gray), shape = Shape.extraSmall) {

            }
            Text(text = "Text")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(modifier = Modifier.size(height = 50.dp, width = 75.dp), border = BorderStroke(0.5.dp,Color.Gray), shape = Shape.extraSmall) {

            }
            Text(text = "Text")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(modifier = Modifier.size(height = 50.dp, width = 75.dp), border = BorderStroke(0.5.dp,Color.Gray), shape = Shape.extraSmall) {

            }
            Text(text = "Text")
        }
    }
}

@Composable
fun FundInformation(modifier: Modifier = Modifier){
    Card(modifier = modifier.height(100.dp), shape = Shape.small, border = BorderStroke(0.5.dp, Color.White)){
        Surface(color = PrimaryColorContainer, modifier = Modifier.fillMaxSize()) {
            Column(modifier = modifier.padding(10.dp), horizontalAlignment = Alignment.Start) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Rp. 32.000.000.00", style = Typography.bodyLarge, color = Color.White)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
                Text(text = "Saldo Kamu", style = Typography.labelMedium, color = Color.White)
            }
        }
    }
}

//@Preview
//@Composable
//fun TopUiPreview(){
//    TopUi()
//}

@Preview
@Composable
fun FundOptionPreview(){
    FundInformation()
}