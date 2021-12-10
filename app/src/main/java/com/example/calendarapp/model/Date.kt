 package com.example.calendarapp.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Date(
    val date: String,
    val localName: String,
    val name: String,
    val countryCode: String,
    val fixed: Boolean,
    val global: Boolean,
    val countries: String?,
    val launchYear: Int?,
    val types: Array<String>
)