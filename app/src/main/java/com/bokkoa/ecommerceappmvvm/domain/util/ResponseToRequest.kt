package com.bokkoa.ecommerceappmvvm.domain.util

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.bokkoa.ecommerceappmvvm.domain.model.ErrorResponse
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

object ResponseToRequest {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun<T> send(result: Response<T>): Resource<T> {
        return try {
            if (result.isSuccessful) { // 201
                Resource.Success(result.body()!!)
            } else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Unknown error")
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Unknown error in http petition")
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Verify your internet connection")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Unknown error")
        }
    }
}
