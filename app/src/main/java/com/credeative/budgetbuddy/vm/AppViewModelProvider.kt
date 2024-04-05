package com.credeative.budgetbuddy.vm

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.credeative.budgetbuddy.activity.login.viewmodel.LoginViewModel
import com.credeative.budgetbuddy.app.application.BudgetBuddyApp

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            val application = (this[APPLICATION_KEY] as BudgetBuddyApp)
            val loginRepository = application.container.loginRepository
            LoginViewModel(application)
        }
//        initializer {
//            val application = (this[APPLICATION_KEY] as BudgetBuddyApp)
//            val repo = application.container.incomeRepository
//
//        }
    }
}

fun CreationExtras.budgetBuddyApp(): BudgetBuddyApp = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BudgetBuddyApp)