package com.credeative.budgetbuddy.dependency.db.repository

import com.credeative.budgetbuddy.data.datamodel.DataExample
import com.credeative.budgetbuddy.dependency.db.dao.ItemDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoryController(private val itemDao: ItemDao):RoomRepository {
    override fun getAllItems(): Flow<List<DataExample>> = itemDao.getAllIncome()
}