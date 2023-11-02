package com.credeative.budgetbuddy.app.application

import android.app.Application
import com.credeative.budgetbuddy.app.AppContainer
import com.credeative.budgetbuddy.app.AppDataContainer

class BudgetBuddyApp:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}