package com.example.cookbook.data

interface OperationCallback<T> {
    fun onSuccess(data: T?)
    fun onError(error: String?)
}