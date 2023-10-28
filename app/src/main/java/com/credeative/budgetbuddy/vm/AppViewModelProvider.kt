package com.credeative.budgetbuddy.vm

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.credeative.budgetbuddy.app.BudgetBuddyApp

object AppViewModelProvider {
    val Factory = viewModelFactory {
//        initializer {
//
//        }
    }
}

fun CreationExtras.budgetBuddyApp():BudgetBuddyApp = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BudgetBuddyApp)