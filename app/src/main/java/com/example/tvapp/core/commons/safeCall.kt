package com.example.tvapp.core.commons

suspend fun <T> safeCall(block: suspend () -> T): Resource<T> {
    return try {
        Resource.Success(block())
    } catch (e: Throwable) {
        Resource.Error(AppException.from(e).message)
    }
}