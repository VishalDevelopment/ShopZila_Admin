package com.example.shoppingadmin.CommonState

sealed class State <out T>{
    data class Success<T>(val data : T): State<T>()
    data class Error<String>(val message : String): State<String>()
object Loading:State<Nothing>()
}