package com.example.calendarapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calendarapp.R
import com.example.calendarapp.ui.calendar.CalendarActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent: Intent = Intent(this, CalendarActivity::class.java)
        startActivity(intent)
    }
}