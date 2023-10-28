package com.credeative.budgetbuddy.app

import com.credeative.budgetbuddy.dependency.db.repository.RoomRepository
import com.credeative.budgetbuddy.dependency.http.repository.RESTApiRepository

interface AppContainer {
    val incomeRepository:RoomRepository
    val restApiRepository: RESTApiRepository
}