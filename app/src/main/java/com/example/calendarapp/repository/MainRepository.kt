package com.example.calendarapp.repository

import com.example.calendarapp.model.Date
import com.example.calendarapp.network.CalendarApi
import com.example.calendarapp.network.NetworkMapper
import com.example.calendarapp.utils.Response
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository
@Inject
constructor(
    private val serviceApi: CalendarApi,
    private val networkMapper: NetworkMapper
    ) {

    suspend fun getCalendar(year: Int, country: String): Flow<Response<List<Date>>> = flow{
        emit(Response.Loading)
        try {
            val networkCalendar = serviceApi.calendarList(year, country)
            val dates = networkMapper.mapFromEntityList(networkCalendar)
            emit(Response.Success(dates))
        } catch (e: Exception) {
            emit(Response.Error(e))
        }
    }
}