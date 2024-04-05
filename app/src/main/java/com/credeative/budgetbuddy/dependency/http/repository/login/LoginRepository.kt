package com.credeative.budgetbuddy.dependency.http.repository.login

interface LoginRepository {
    suspend fun requestLoginWithGoogle()
}