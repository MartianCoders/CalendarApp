package com.example.calendarapp.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.calendarapp.activities.calendarActivity.CalendarActivityVM
import com.example.calendarapp.api.ServiceApi
import com.example.calendarapp.repository.Repository
import java.lang.IllegalArgumentException

class VMFactory(private val serviceApi: ServiceApi): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CalendarActivityVM::class.java)) {
            return CalendarActivityVM(Repository(serviceApi)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}