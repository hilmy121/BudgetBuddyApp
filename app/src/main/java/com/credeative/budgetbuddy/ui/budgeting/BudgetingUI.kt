package com.credeative.budgetbuddy.ui.budgeting

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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.ui.theme.PrimaryColorBg
import com.credeative.budgetbuddy.ui.theme.PrimaryColorContainer
import com.credeative.budgetbuddy.ui.theme.Shape
import com.credeative.budgetbuddy.ui.theme.TertiaryBorderColor
import com.credeative.budgetbuddy.ui.theme.TopUiShape
import com.credeative.budgetbuddy.ui.theme.Typography
import com.credeative.budgetbuddy.ui.theme.linearGradientCardAmount


@Composable
fun BudgetingTopUI(modifier: Modifier = Modifier){
//    Card(colors = CardDefaults.cardColors(containerColor = Color.Gray)) {
//
//    }
    FundInformation()
}
@Composable
fun FundInformation(modifier:Modifier = Modifier){
    Card(modifier = modifier.height(75.dp), shape = Shape.small, border = BorderStroke(0.5.dp, Color.White), colors = CardDefaults.cardColors(containerColor = TertiaryBorderColor)){
        Column(modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.Start) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Total Bulan Ini", style = Typography.labelMedium, color = Color.White)

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.ic_show_eye),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
                )
            }
            Text(text = "Rp. 32.000.000.00", style = Typography.bodyLarge, color = Color.White)
        }
    }
}
@Composable
fun FundFilter(modifier:Modifier = Modifier){
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
        Card(modifier = Modifier.size(85.dp)) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BudgetingTopUIPreview(){
    BudgetingTopUI()
}