package com.credeative.budgetbuddy.activity.login.viewmodel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.credeative.budgetbuddy.R
import com.credeative.budgetbuddy.data.state.LoginState
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.annotation.Nullable

class LoginViewModel (private val application: Application): ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState = _uiState.asStateFlow()
//    private val emailState = MutableStateFlow("")
//    val readEmailState = emailState.asStateFlow()
    private val email = MutableLiveData<String>()
    fun loginWithGoogle(@Nullable launcher:ActivityResultLauncher<Intent>?){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        val googleSignInClient = GoogleSignIn.getClient(application.applicationContext,gso)
        val signInIntent = googleSignInClient.signInIntent
        launcher?.launch(signInIntent)
    }

    fun updateEmail(logEmail:String):LiveData<String>{
        email.postValue(logEmail)
        return email
    }

//    fun updateEmailState(email:String){
//        emailState.value = email
//    }

//    private fun handleGoogleSignIn(completedTask : Task<GoogleSignInAccount>){
//        try {
//            var account = completedTask.getResult(ApiException::class.java)
//        }catch (e: ApiException){
//            Log.e("signInResult:failed code=",  e.statusCode.toString())
//        }
//    }

}