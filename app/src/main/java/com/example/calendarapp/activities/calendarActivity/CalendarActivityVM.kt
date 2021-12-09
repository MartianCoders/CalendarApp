package com.example.calendarapp.activities.calendarActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.calendarapp.repository.Repository
import com.example.calendarapp.utils.Response
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class CalendarActivityVM(private val repository: Repository): ViewModel() {

    fun getCalendar(year: Int, country: String) = liveData(Dispatchers.IO) {
        emit(Response.loading(data = null))
        try {
            emit(Response.succes(repository.getCalendar(year, country)))
        } catch (exception: Exception) {
            emit(Response.error(data = null, message = exception.message.toString()))
        }

    }
}