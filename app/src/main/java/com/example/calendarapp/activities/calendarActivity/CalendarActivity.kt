package com.example.calendarapp.activities.calendarActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calendarapp.R
import com.example.calendarapp.activities.VMFactory
import com.example.calendarapp.api.RetrofitBuilder
import com.example.calendarapp.api.ServiceApi
import com.example.calendarapp.utils.Status

class CalendarActivity : AppCompatActivity() {

    private lateinit var viewModel: CalendarActivityVM
    private lateinit var calendarRecyclerView: RecyclerView

    private var adapter: RecyclerViewAdapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        viewModel = ViewModelProvider(
            this,
            VMFactory(
                ServiceApi(RetrofitBuilder.calendarApi)
            )
        ).get(CalendarActivityVM::class.java)


        calendarRecyclerView = findViewById(R.id.calendar_recycler_view)
        calendarRecyclerView.layoutManager = LinearLayoutManager(this)

        manageObservers()
    }

    private fun manageObservers() {
        viewModel.getCalendar(2021, "RO").observe(this, Observer {
            it?.let { response ->
                when(response.status) {
                    Status.SUCCES -> {
                        response.data?.let { it1 -> adapter.updateList(it1) }
                        calendarRecyclerView.adapter = adapter
                    }

                    Status.ERROR -> {
                        println(it.message)
                    }

                    Status.LOADING -> {
                        println("Loading..")
                    }
                }
            }
        })
    }
}