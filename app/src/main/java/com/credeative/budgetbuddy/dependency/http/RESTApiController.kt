package com.credeative.budgetbuddy.dependency.http

import com.credeative.budgetbuddy.dependency.http.repository.RESTApiRepository

class RESTApiController(val restApiEndpoint: RESTApiEndpoint) : RESTApiRepository {

}