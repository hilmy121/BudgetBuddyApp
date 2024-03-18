@file:OptIn(ExperimentalMaterial3Api::class)

package com.credeative.budgetbuddy.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.data.datamodel.Needs

@Composable
fun HomeContentUI(allocationList: List<Needs>,transactionList: List<Needs>){
    Column (
        modifier=Modifier.fillMaxWidth().wrapContentHeight()){

        FundOptionTab(allocations = allocationList, transactions = transactionList)

    }
}






