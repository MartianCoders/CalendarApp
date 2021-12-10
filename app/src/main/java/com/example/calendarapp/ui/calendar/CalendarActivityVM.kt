package com.example.calendarapp.ui.calendar

import androidx.lifecycle.*
import com.example.calendarapp.model.Date
import com.example.calendarapp.repository.MainRepository
import com.example.calendarapp.utils.Response
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CalendarActivityVM
@Inject
constructor(
    private val mainRepository: MainRepository,
): ViewModel() {

    private val response: MutableLiveData<Response<List<Date>>> = MutableLiveData()

    val dataState: LiveData<Response<List<Date>>>
        get() = response

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetCalendarEvents -> {
                    mainRepository.getCalendar(2022, "RO")
                        .onEach { dataState ->
                            response.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                is MainStateEvent.None -> {
                    println("None")
                }
            }
        }
    }

}

sealed class MainStateEvent{
    object GetCalendarEvents: MainStateEvent()

    object None: MainStateEvent()
}