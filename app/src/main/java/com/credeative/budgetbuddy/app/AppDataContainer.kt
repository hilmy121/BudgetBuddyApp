package com.credeative.budgetbuddy.app

import android.content.Context
import com.credeative.budgetbuddy.dependency.db.IncomeDatabase
import com.credeative.budgetbuddy.dependency.db.repository.OfflineRepositoryController
import com.credeative.budgetbuddy.dependency.db.repository.RoomRepository

class AppDataContainer(private val context: Context):AppContainer {
    override val incomeRepository: RoomRepository by lazy {
        OfflineRepositoryController(IncomeDatabase.getDatabase(context).itemDao())
    }
}