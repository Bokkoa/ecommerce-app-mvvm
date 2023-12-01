package com.bokkoa.ecommerceappmvvm.domain.util

import android.util.Log
import com.bokkoa.ecommerceappmvvm.domain.model.ErrorResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import java.lang.Exception

object ConvertErrorBody {

    fun convert(errorBody: ResponseBody?): ErrorResponse? {
        return try {
            errorBody?.source()?.let {
                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
                Log.d("Error from backend", it.toString())
                moshiAdapter.fromJson(it)
            }
        } catch (e: Exception) {
            Log.d("ConvertErrorBody", "Error: " + e.message.toString())
            null
        }
    }
}
