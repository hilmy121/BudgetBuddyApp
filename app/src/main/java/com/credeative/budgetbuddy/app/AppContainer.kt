package com.credeative.budgetbuddy.app

import com.credeative.budgetbuddy.dependency.db.repository.RoomRepository

interface AppContainer {
    val incomeRepository:RoomRepository
}