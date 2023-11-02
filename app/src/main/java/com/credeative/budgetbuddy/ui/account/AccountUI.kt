package com.credeative.budgetbuddy.ui.account

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
import com.credeative.budgetbuddy.ui.theme.BlackBorderStrokeColor
import com.credeative.budgetbuddy.ui.theme.GreyBorderStrokeColor
import com.credeative.budgetbuddy.ui.theme.PrimaryTextColor
import com.credeative.budgetbuddy.ui.theme.Shape
import com.credeative.budgetbuddy.ui.theme.Typography

@Composable
fun AccountUI(){
    Column (modifier = Modifier
        .padding(20.dp)
        .fillMaxSize(),verticalArrangement = Arrangement.spacedBy(10.dp)){
        UserInformation()

        Spacer(modifier = Modifier.fillMaxWidth().height(50.dp))

        Card(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp), shape = Shape.extraSmall, border = BorderStroke(0.5.dp, GreyBorderStrokeColor)){
            Surface(color = Color.White, modifier = Modifier.fillMaxSize()){
                Column(modifier=Modifier.padding(horizontal = 10.dp),verticalArrangement = Arrangement.SpaceEvenly) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Tentang Kami", style = Typography.bodySmall)
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp), shape = Shape.extraSmall, border = BorderStroke(0.5.dp, GreyBorderStrokeColor)){
            Surface(color = Color.White, modifier = Modifier.fillMaxSize()){
                Column(modifier=Modifier.padding(horizontal = 10.dp),verticalArrangement = Arrangement.SpaceEvenly) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Singkron Data Sekarang", style = Typography.bodySmall)
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))

        Card(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp), shape = Shape.extraSmall, border = BorderStroke(0.5.dp, GreyBorderStrokeColor)){
            Surface(color = Color.White, modifier = Modifier.fillMaxSize()){
                Column(modifier=Modifier.padding(horizontal = 10.dp),verticalArrangement = Arrangement.SpaceEvenly) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Keluar", style = Typography.bodySmall)
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
@Composable
fun UserInformation(modifier: Modifier = Modifier){

        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = Shape.small,
            border = BorderStroke(0.5.dp, BlackBorderStrokeColor)
        ) {
            Surface(color = Color.White) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
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
                            Text(text = "Meliusa Nora Hariyanti", style = Typography.bodyLarge, color = PrimaryTextColor)
                            Text(text = "cookiescaca@gmail.com", style = Typography.bodyMedium,color = PrimaryTextColor)
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
}
@Preview(showBackground = true)
@Composable
fun AccountUIPreview(){
    AccountUI()
}
