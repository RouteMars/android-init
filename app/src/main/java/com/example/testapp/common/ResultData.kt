package com.example.testapp.common

sealed class ResultData<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null) : ResultData<T>(data)
    class Success<T>(data: T) : ResultData<T>(data)
    class Error<T>(message: String, data: T? = null) : ResultData<T>(data, message)
}