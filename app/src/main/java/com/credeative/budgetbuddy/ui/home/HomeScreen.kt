package com.credeative.budgetbuddy.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreenUI(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight().padding(6.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.fillMaxWidth()
            .wrapContentHeight(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            HomeTopUI()
            HomeContentUI()
        }

    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenUIPreview(){
    HomeScreenUI()
}