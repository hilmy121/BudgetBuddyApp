package com.credeative.budgetbuddy.dependency.db.repository

import com.credeative.budgetbuddy.data.datamodel.DataExample
import kotlinx.coroutines.flow.Flow

interface RoomRepository {
    fun getAllItems(): Flow<List<DataExample>>
}