package com.credeative.budgetbuddy.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.ui.theme.Shape

class AccountItemUI {

    @Composable
    fun AccountItem(){
        Card(
            modifier = Modifier.size(width = 65.dp, height = 50.dp),
            shape = Shape.extraSmall,
            colors = CardDefaults.cardColors()

        ) {
            Box(modifier = Modifier.fillMaxSize()){
                Column (modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.TopCenter)
                    .padding(vertical = 8.dp)){
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .size(5.dp),horizontalArrangement = Arrangement.SpaceBetween){
                        Card (
                            modifier = Modifier.size(width = 32.dp, height = 5.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.Gray)){

                        }
                        Icon(painter = painterResource(id = (R.drawable.ic_arrow_back)), contentDescription = null)
                    }

                    Text(modifier = Modifier.fillMaxWidth().padding(top = 7.dp),text = "Utama", fontSize = 6.sp)
                    Text(modifier = Modifier.fillMaxWidth().padding(top = 2.dp),text = "Rp. 13.000.000", fontSize = 4.sp)
                    Text(modifier = Modifier.fillMaxWidth().padding(top = 2.dp),text = "Simpanan Komitmen", fontSize = 3.sp)
                }

            }

        }
    }

    @Composable
    @Preview
    fun AccountItemPreview(){
        AccountItem()
    }
}