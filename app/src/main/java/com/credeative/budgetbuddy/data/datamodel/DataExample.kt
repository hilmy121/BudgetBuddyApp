package com.credeative.budgetbuddy.data.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class DataExample (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val price: Double,
    val quantity: Int
)