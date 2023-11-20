package com.bokkoa.ecommerceappmvvm.data.service

import com.bokkoa.ecommerceappmvvm.domain.model.User
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {
    // http://192.168.100.2:3000/auth/login
    @FormUrlEncoded
    @POST("/auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("Password") password: String,
    ): Response<User>
}