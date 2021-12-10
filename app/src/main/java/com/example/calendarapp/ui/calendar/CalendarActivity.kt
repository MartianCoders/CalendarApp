package com.example.calendarapp.ui.calendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.calendarapp.utils.Response
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calendarapp.R
import com.example.calendarapp.model.Date
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class CalendarActivity : AppCompatActivity() {

    private val viewModel: CalendarActivityVM by viewModels()
    private var adapter: RecyclerViewAdapter = RecyclerViewAdapter()
    private lateinit var calendarRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarRecyclerView = findViewById(R.id.calendar_recycler_view)
        calendarRecyclerView.layoutManager = LinearLayoutManager(this)

        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetCalendarEvents)
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this, Observer { response ->
            when(response) {
                is Response.Success<List<Date>> -> {
                    adapter.updateList(response.data)
                    calendarRecyclerView.adapter = adapter
                }

                is Response.Error -> {
                    Log.i("DEBUG", response.exception.toString())
                }

                is Response.Loading -> {
                    Log.i("DEBUG", "Loading..")
                }
            }
        })
    }
}