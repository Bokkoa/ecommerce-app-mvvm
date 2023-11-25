package com.bokkoa.ecommerceappmvvm.domain.util

import java.lang.Exception

sealed class ResourceResponse<out T> {
    object Loading : ResourceResponse<Nothing>()
    data class Success<out T>(val data: T) : ResourceResponse<T>()
    data class Failure<out T>(val message: String) : ResourceResponse<T>()
}
