package com.rupp.newsapp.core.network

object ErrorHandler {
    fun getErrorMessage(exception: Throwable): String {
        return when (exception) {
            is java.net.UnknownHostException -> "No internet connection"
            is java.net.SocketTimeoutException -> "Request timed out"
            else -> exception.localizedMessage ?: "Unknown error"
        }
    }
}