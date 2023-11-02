package com.credeative.budgetbuddy.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.credeative.budgetbuddy.R

@Composable
fun StartupUI(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(Modifier.align(Alignment.Center).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.ic_hero_budget_buddy_20), contentDescription = null)
            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.ic_hero_budget_buddy_text_20), contentDescription = null)
            Spacer(modifier = Modifier.weight(0.8f))
            Image(painter = painterResource(id = R.drawable.ic_credeative), contentDescription = null)
            Spacer(modifier = Modifier.weight(0.2f))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartupUIPreview() {
    StartupUI()
}