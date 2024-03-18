package com.credeative.budgetbuddy.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.data.datamodel.Needs
import com.credeative.budgetbuddy.ui.theme.PrimaryNeeds
import com.credeative.budgetbuddy.ui.theme.SecondaryNeeds
import com.credeative.budgetbuddy.ui.theme.TertiaryNeeds

@Composable
fun HomeScreenUI(){

    val allocationList by remember {
        mutableStateOf(listOf(
            Needs(color = Color(0xFF4891FF),"Primary",6500000, false),
            Needs(color = Color(0xFFFF753A),"Fun Cart",500000,false),
            Needs(color = Color(0xFF00C77F),"Saving",1500000,false)
        ))
    }
    val transactionList by remember {
        mutableStateOf(listOf(
            Needs(color = PrimaryNeeds,"Pemasukan",7000000, false),
            Needs(color = SecondaryNeeds,"Pengeluaran",2500000,false),
        ))
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(6.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            HomeTopUI()
            HomeContentUI(allocationList, transactionList)
        }

    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenUIPreview(){
    HomeScreenUI()
}