package com.bokkoa.ecommerceappmvvm.data.repository

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import com.bokkoa.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.bokkoa.ecommerceappmvvm.domain.model.AuthResponse
import com.bokkoa.ecommerceappmvvm.domain.model.ErrorResponse
import com.bokkoa.ecommerceappmvvm.domain.model.User
import com.bokkoa.ecommerceappmvvm.domain.repository.AuthRepository
import com.bokkoa.ecommerceappmvvm.domain.util.ConvertErrorBody
import com.bokkoa.ecommerceappmvvm.domain.util.ResourceResponse
import java.io.IOException
import java.lang.Exception

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource) : AuthRepository {
    override suspend fun login(email: String, password: String): ResourceResponse<AuthResponse> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            if (result.isSuccessful) { // 201
                ResourceResponse.Success(result.body()!!)
            } else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                ResourceResponse.Failure(errorResponse?.message ?: "Unknown error")
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            ResourceResponse.Failure(e.message ?: "Unknown error in http petition")
        } catch (e: IOException) {
            e.printStackTrace()
            ResourceResponse.Failure(e.message ?: "Verify your internet connection")
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceResponse.Failure(e.message ?: "Unknown error")
        }
    }

    override suspend fun register(user: User): ResourceResponse<AuthResponse> {
        return try {
            val result = authRemoteDataSource.register(user)

            if (result.isSuccessful) { // 201
                ResourceResponse.Success(result.body()!!)
            } else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                ResourceResponse.Failure(errorResponse?.message ?: "Unknown error")
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            ResourceResponse.Failure(e.message ?: "Unknown error in http petition")
        } catch (e: IOException) {
            e.printStackTrace()
            ResourceResponse.Failure(e.message ?: "Verify your internet connection")
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceResponse.Failure(e.message ?: "Unknown error")
        }
    }
}
