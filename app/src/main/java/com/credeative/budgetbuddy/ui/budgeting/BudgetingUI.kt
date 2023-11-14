package com.credeative.budgetbuddy.ui.budgeting

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BudgetingTopUI(modifier: Modifier = Modifier, expenseSelected:Boolean = false,inComeOnClick:()->Unit={},expenseOnClick:()->Unit={}){
    Surface(modifier = modifier
        .fillMaxWidth(), color = Color.White) {
        Column (verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.height(20.dp))
            Surface(modifier = Modifier
                .fillMaxWidth(0.95f)
                .height(40.dp), shape = Shape.small, border = BorderStroke(1.dp, color = Color.Gray)) {
                Row (modifier = Modifier.fillMaxSize()){
                    Card(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f), colors = CardDefaults.cardColors(containerColor =
                    if (!expenseSelected){
                        PrimaryColorBg}else{
                        Color.White
                    }), shape = Shape.extraSmall, onClick = inComeOnClick) {
                        Box(modifier = Modifier.fillMaxSize()){
                            Text(text = "Pemasukan", modifier = Modifier.align(alignment = Alignment.Center))
                        }
                    }
                    Card(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f), colors = CardDefaults.cardColors(containerColor =
                    if (expenseSelected){
                        PrimaryColorBg}else{
                        Color.White
                    }), shape = Shape.extraSmall, onClick = expenseOnClick) {
                        Box(modifier = Modifier.fillMaxSize()){
                            Text(text = "Pengeluaran", modifier = Modifier.align(alignment = Alignment.Center))
                        }
                    }
                }
            }
            FundInformation()

            FundFilter()
        }
    }

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

        Row (modifier = modifier.fillMaxWidth(0.95f), horizontalArrangement = Arrangement.SpaceBetween){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Card(modifier = Modifier.size(height = 35.dp, width = 85.dp),colors = CardDefaults.cardColors(containerColor = Color.Transparent), border = BorderStroke(1.dp,Color.Gray), shape = Shape.extraSmall) {

                }
                Text(text = "Tambah",modifier=Modifier.width(75.dp), textAlign = TextAlign.Center, maxLines = 2, style = MaterialTheme.typography.bodySmall)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Card(modifier = Modifier.size(height = 35.dp, width = 85.dp),colors = CardDefaults.cardColors(containerColor = Color.Transparent), border = BorderStroke(1.dp,Color.Gray), shape = Shape.extraSmall) {

                }
                Text(text = "Kategori",modifier=Modifier.width(75.dp), textAlign = TextAlign.Center, maxLines = 2, style = MaterialTheme.typography.bodySmall)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Card(modifier = Modifier.size(height = 35.dp, width = 85.dp),colors = CardDefaults.cardColors(containerColor = Color.Transparent), border = BorderStroke(1.dp,Color.Gray), shape = Shape.extraSmall) {

                }
                Text(text = "Analisa",modifier=Modifier.width(75.dp), textAlign = TextAlign.Center, maxLines = 2, style = MaterialTheme.typography.bodySmall)
            }
        }

}

@Preview(showBackground = true)
@Composable
fun BudgetingTopUIPreview(){
    var expenseSelected by rememberSaveable {
        mutableStateOf(false)
    }
    BudgetingTopUI(
        expenseSelected = expenseSelected,
        expenseOnClick = {
            expenseSelected = true },
        inComeOnClick = {
            expenseSelected = false

        })
}