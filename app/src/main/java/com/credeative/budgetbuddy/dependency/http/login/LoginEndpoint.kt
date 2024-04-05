package com.credeative.budgetbuddy.dependency.http.login

import retrofit2.http.GET

interface LoginEndpoint {
    //API request here
    @GET
    suspend fun loginWithGmail()
}