package com.credeative.budgetbuddy.dependency.http.login

import com.credeative.budgetbuddy.dependency.http.repository.login.LoginRepository

class LoginController(val loginEndpoint: LoginEndpoint): LoginRepository {
    override suspend fun requestLoginWithGoogle() = loginEndpoint.loginWithGmail()
}