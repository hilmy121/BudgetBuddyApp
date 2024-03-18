package com.credeative.budgetbuddy.activity.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.credeative.budgetbuddy.activity.login.viewmodel.LoginViewModel
import com.credeative.budgetbuddy.ui.login.LoginOption
import com.credeative.budgetbuddy.ui.login.LoginOptionScreen
import com.credeative.budgetbuddy.ui.theme.BudgetBuddyTheme
import com.credeative.budgetbuddy.vm.AppViewModelProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class LoginActivity : ComponentActivity() {
    lateinit var loginViewModel: LoginViewModel
    lateinit var accountResult:Any
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> if (result.resultCode == Activity.RESULT_OK){
            val data = result.data
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }
    private fun handleSignInResult(completedTask : Task<GoogleSignInAccount>){
        try {
            val account = completedTask.getResult(ApiException::class.java)
            if (account != null) {
                accountResult = account
                account.email?.let {
                    loginViewModel.updateEmail(it).observe(this){
                        email ->
                        if (email != null) {
                            Log.i("email","Not null")
                        }
                    }
                }
//                val registerIntent = Intent

            }
        }catch (e:ApiException){
            Log.e("signInResult:failed code=",  e.statusCode.toString())
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetBuddyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    loginViewModel = ViewModelProvider(this,factory = AppViewModelProvider.Factory)[LoginViewModel::class.java]
//                    val vm: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)
                    LoginOption(viewModel = loginViewModel, launcher = resultLauncher)
//                    ViewpagerApp(Modifier.fillMaxSize())
                }
            }
        }

    }
//    private fun getGoogleSignInLauncher(signInHandler:(completedTask : Task<GoogleSignInAccount>)->Unit):ActivityResultLauncher<Intent>{
//        return registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//                result -> if (result.resultCode == Activity.RESULT_OK){
//            val data = result.data
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            signInHandler(task)
//            }
//        }
//    }

//    private fun LoginWithGoogleIntent(){
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
//        val googleSignInClient = GoogleSignIn.getClient(application.applicationContext,gso)
//        val signInIntent = googleSignInClient.signInIntent
//        resultLauncher.launch(signInIntent)
//
//
//    }



}

