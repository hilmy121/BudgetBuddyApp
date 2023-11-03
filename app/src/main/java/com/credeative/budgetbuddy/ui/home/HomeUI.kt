package com.credeative.budgetbuddy.ui.home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.ui.theme.PrimaryColorBg
import com.credeative.budgetbuddy.ui.theme.PrimaryColorContainer
import com.credeative.budgetbuddy.ui.theme.PrimaryTextColor
import com.credeative.budgetbuddy.ui.theme.Shape
import com.credeative.budgetbuddy.ui.theme.TopUiShape
import com.credeative.budgetbuddy.ui.theme.Typography

@Composable
fun HomeUi(){

}

@Composable
fun TopUi(modifier: Modifier=Modifier){
    Surface(modifier = modifier
        .fillMaxWidth(), shape = TopUiShape.medium, color = PrimaryColorBg) {
        Row (modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically){
            Spacer(modifier = Modifier
                .fillMaxHeight()
                .width(10.dp))
            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                AccountInformation()
                Spacer(modifier = Modifier.size(40.dp))
                FundInformation()
                Spacer(modifier = Modifier.size(40.dp))
                FundOption()
            }
            Spacer(modifier = Modifier
                .fillMaxHeight()
                .width(10.dp))
        }

    }
}
@Composable
fun ContentUI(modifier: Modifier=Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.aligned(alignment = Alignment.CenterVertically)) {

        Text(modifier = modifier.padding(horizontal = 15.dp, vertical = 10.dp), text = "Transaksi Terakhir")
//        LazyColumn(content = )

    }
}
@Composable
fun AccountInformation(modifier: Modifier=Modifier){
    Row(modifier=modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .padding(5.dp),
            painter = painterResource(id = R.drawable.ic_user_home),
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
        Image(
            modifier = Modifier
                .size(33.dp)
                .padding(5.dp),
            painter = painterResource(id = R.drawable.ic_notification_home_active),
            contentDescription = null
        )
    }
}
@Composable
fun FundOption(modifier: Modifier = Modifier){
    Row (modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(modifier = Modifier.size(height = 35.dp, width = 75.dp),color = Color.Transparent, border = BorderStroke(0.5.dp,Color.Gray), shape = Shape.extraSmall) {

            }
            Text(text = "Tambah Pemasukan",modifier=Modifier.width(75.dp), textAlign = TextAlign.Center, maxLines = 2, style = MaterialTheme.typography.bodySmall)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(modifier = Modifier.size(height = 35.dp, width = 75.dp),color = Color.Transparent, border = BorderStroke(0.5.dp,Color.Gray), shape = Shape.extraSmall) {

            }
            Text(text = "Tambah Pengeluaran",modifier=Modifier.width(75.dp), textAlign = TextAlign.Center, maxLines = 2, style = MaterialTheme.typography.bodySmall)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(modifier = Modifier.size(height = 35.dp, width = 75.dp),color = Color.Transparent, border = BorderStroke(0.5.dp,Color.Gray), shape = Shape.extraSmall) {

            }
            Text(text = "Kategori Transaksi",modifier=Modifier.width(75.dp), textAlign = TextAlign.Center, maxLines = 2, style = MaterialTheme.typography.bodySmall)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Surface(modifier = Modifier.size(height = 35.dp, width = 75.dp),color = Color.Transparent, border = BorderStroke(0.5.dp,Color.Gray), shape = Shape.extraSmall) {

            }
            Text(text = "Semua Transaksi",modifier=Modifier.width(75.dp), textAlign = TextAlign.Center, maxLines = 2, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun FundInformation(modifier: Modifier = Modifier){
    Card(modifier = modifier.height(75.dp), shape = Shape.small, border = BorderStroke(0.5.dp, Color.White)){
        Surface(color = PrimaryColorContainer, modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
            ){
                Row (modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterEnd), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Top){
                    Spacer(modifier = Modifier.fillMaxWidth(0.5f))
                    Image(
                        painter = painterResource(id = R.drawable.bg_amount_card_green),
                        contentDescription = null,
                        modifier=Modifier.weight(0.5f),
                        contentScale = ContentScale.Crop)
                }
                Column(modifier = modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.Center), horizontalAlignment = Alignment.Start) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Rp. 32.000.000.00", style = Typography.bodyLarge, color = Color.White)
                        Spacer(modifier = Modifier.weight(1f))

                        Image(
                            painter = painterResource(id = R.drawable.ic_show_eye),
                            contentDescription = null,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                    Text(text = "Saldo Kamu", style = Typography.labelMedium, color = Color.White)
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopUiPreview(){
    TopUi()
}

@Preview(showBackground = true)
@Composable
fun ContentUIPreview(){
    ContentUI()
}

//@Preview(showBackground = true)
//@Composable
//fun FundOptionPreview(){
//    TopUi()
//}