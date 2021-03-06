package com.example.calendarapp.network

import retrofit2.http.GET
import retrofit2.http.Path

interface CalendarApi {

    @GET("/api/v3/PublicHolidays/{Year}/{CountryCode}")
    suspend fun calendarList(
        @Path("Year") year: Int,
        @Path("CountryCode") country: String
    ): List<DateNetworkEntity>
}