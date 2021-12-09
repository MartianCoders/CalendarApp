package com.example.calendarapp.api

class ServiceApi(private val calendarApi: CalendarApi) {

    suspend fun getCalendar(year: Int, country: String) = calendarApi.calendarList(year, country)
}