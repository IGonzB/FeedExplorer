package com.example.feedexplorer.domain.model

/**
 * wrapper travels through the architecture layers to describe the lifecycle of a request:
 */
sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
}