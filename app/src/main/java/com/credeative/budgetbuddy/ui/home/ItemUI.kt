package com.credeative.budgetbuddy.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.ui.theme.PrimaryColor
import com.credeative.budgetbuddy.ui.theme.Shape

@Composable
fun TransactionItem(modifier:Modifier=Modifier.padding(horizontal = 10.dp)){
    Card(modifier = modifier.fillMaxWidth(), shape = Shape.small, border = BorderStroke(0.3.dp, Color.Gray)) {
        Surface(color = Color.White) {
            Row(modifier=modifier.padding(vertical = 15.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = modifier
                        .size(20.dp)
                        .clip(Shape.extraSmall),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentScale = ContentScale.Crop,
                    contentDescription = null)
                Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Tumbas es", style = MaterialTheme.typography.bodyLarge, color = PrimaryColor)
                    Text(text = "Pengeluaran", style = MaterialTheme.typography.bodySmall)
                    Text(text = "26 Oktober 2023", style = MaterialTheme.typography.bodySmall)
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(modifier= modifier
                    .padding(end = 10.dp),horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Total Pemasukan", style = MaterialTheme.typography.labelSmall)
                    Text(text = "Rp 2.700.000", style = MaterialTheme.typography.bodyMedium, color = PrimaryColor)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TransactionItemPreview(){
    TransactionItem()
}