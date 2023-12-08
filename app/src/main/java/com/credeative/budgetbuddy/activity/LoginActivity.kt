package com.credeative.budgetbuddy.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.credeative.budgetbuddy.ui.login.LoginScreen
import com.credeative.budgetbuddy.ui.login.ViewpagerApp
import com.credeative.budgetbuddy.ui.login.ViewpagerAppExample
import com.credeative.budgetbuddy.ui.theme.BudgetBuddyTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetBuddyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
//                    ViewpagerApp(Modifier.fillMaxSize())
                }
            }
        }
    }
}

