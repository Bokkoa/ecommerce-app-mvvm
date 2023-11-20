package com.bokkoa.ecommerceappmvvm.domain.repository

import com.bokkoa.ecommerceappmvvm.domain.model.User
import com.bokkoa.ecommerceappmvvm.domain.util.Response

interface AuthRepository {
    suspend fun login(email: String, password: String): Response<User>
}