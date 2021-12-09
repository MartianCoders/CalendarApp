package com.example.calendarapp.repository

import com.example.calendarapp.api.ServiceApi

class Repository(private val serviceApi: ServiceApi) {

    suspend fun getCalendar(year: Int, country: String) = serviceApi.getCalendar(year, country)
}