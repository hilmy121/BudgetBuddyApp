package com.credeative.budgetbuddy.dependency.http

import com.credeative.budgetbuddy.dependency.http.repository.RESTApiRepository

class RESTApiController(val restApiEndpoint: RESTApiEndpoint) : RESTApiRepository {
    override suspend fun requestLoginWithGoogle() {
        TODO("example:restApiEndpoint.login")
    }

}