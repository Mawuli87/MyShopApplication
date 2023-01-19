package com.messieyawo.com.myshopapplication.resource

sealed class Resource<T>(
    val data :T?=null,
    val message:String?=null
) {

    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String?) : Resource<T>(null,message)
    class Loading<T> : Resource<T>()
}