package com.credeative.budgetbuddy.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.credeative.budgetbuddy.activity.login.LoginActivity
import com.credeative.budgetbuddy.ui.login.StartupUI
import com.credeative.budgetbuddy.ui.theme.BudgetBuddyTheme
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
//    var firebaseUser : FirebaseUser? = null
    var account : GoogleSignInAccount? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetBuddyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StartupUI()
                }
            }
        }



        CoroutineScope(Dispatchers.Main).launch {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            delay(3000)
            account = GoogleSignIn.getLastSignedInAccount(this@MainActivity)
//            firebaseUser = Firebase.auth.currentUser
            if (account != null) {
//                Log.i("Route:","Home ${account!!.email}")
                Log.i("Route:","Home ${account?.email}")

            }else{
                Log.i("Route:","Login Option")
            }

            startActivity(intent)
            this@MainActivity.finish()
        }
    }
}
