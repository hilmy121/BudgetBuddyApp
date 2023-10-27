package com.credeative.budgetbuddy.dependency.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.credeative.budgetbuddy.data.datamodel.DataExample
import com.credeative.budgetbuddy.dependency.db.dao.ItemDao

@Database(entities = [DataExample::class], version = 1, exportSchema = false)
abstract class IncomeDatabase : RoomDatabase() {
    abstract suspend fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance : IncomeDatabase? = null

        fun getDatabase(context: Context):IncomeDatabase{
            return Instance?: synchronized(this, block = {
                Room.databaseBuilder(context = context, klass = IncomeDatabase::class.java,"item_database").build().also {
                    database -> Instance = database
                }
            })
        }
    }
}