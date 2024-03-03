@file:OptIn(ExperimentalMaterial3Api::class)

package com.credeative.budgetbuddy.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeContentUI(){
    Column (
        modifier=Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)){

        FundOptionTab()

    }
}




@Composable
@Preview(showBackground = true)
fun HomeContentUIPreview(){
    HomeContentUI()
}

