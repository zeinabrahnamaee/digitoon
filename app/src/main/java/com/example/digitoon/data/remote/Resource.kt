package com.example.digitoon.data.remote


sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    class Error<T>(val message: String) : Resource<T>()
    class Loading<T> : Resource<T>()
}