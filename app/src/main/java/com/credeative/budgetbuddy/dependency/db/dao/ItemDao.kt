package com.credeative.budgetbuddy.dependency.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.credeative.budgetbuddy.data.datamodel.DataExample
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addIncome(dataExample: DataExample)

    @Update
    suspend fun updateSaving(dataExample: DataExample)

    @Query("SELECT * from items ORDER BY price ASC")
    fun getAllIncome():Flow<List<DataExample>>



}