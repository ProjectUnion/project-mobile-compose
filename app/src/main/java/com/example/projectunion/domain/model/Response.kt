package com.example.projectunion.domain.model

/*sealed class Response<T>(val data: T? = null, val message: String? = null) {
	class Success<T>(data: T) : Resource<T>(data)
	class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
	class Loading<T>(data: T? = null) : Resource<T>(data)
}*/

sealed class Response<out T> {
	object Loading: Response<Nothing>()
	data class Success<out T>(val data: T): Response<T>()
	data class Error(val message: String): Response<Nothing>()
}