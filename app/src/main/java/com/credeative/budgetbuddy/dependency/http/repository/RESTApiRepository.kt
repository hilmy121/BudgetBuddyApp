package com.credeative.budgetbuddy.dependency.http.repository

interface RESTApiRepository {
    suspend fun requestLoginWithGoogle()
}