package com.example.calendarapp.utils

data class Response<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> succes(data: T):
                Response<T> = Response(Status.SUCCES, data, null)

        fun <T> error(data: T?, message: String):
                Response<T> = Response(Status.ERROR, data, message)

        fun <T> loading(data: T?):
                Response<T> = Response(Status.LOADING, data, null)

    }
}