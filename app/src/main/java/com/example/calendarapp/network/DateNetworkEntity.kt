package com.example.calendarapp.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DateNetworkEntity(
    @SerializedName("date")
    @Expose
    val date: String,

    @SerializedName("localName")
    @Expose
    val localName: String,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("countryCode")
    @Expose
    val countryCode: String,

    @SerializedName("fixed")
    @Expose
    val fixed: Boolean,

    @SerializedName("global")
    @Expose
    val global: Boolean,

    @SerializedName("countries")
    @Expose
    val countries: String?,

    @SerializedName("launchYear")
    @Expose
    val launchYear: Int?,

    @SerializedName("types")
    @Expose
    val types: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DateNetworkEntity

        if (date != other.date) return false
        if (localName != other.localName) return false
        if (name != other.name) return false
        if (countryCode != other.countryCode) return false
        if (fixed != other.fixed) return false
        if (global != other.global) return false
        if (countries != other.countries) return false
        if (launchYear != other.launchYear) return false
        if (!types.contentEquals(other.types)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = date.hashCode()
        result = 31 * result + localName.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + countryCode.hashCode()
        result = 31 * result + fixed.hashCode()
        result = 31 * result + global.hashCode()
        result = 31 * result + (countries?.hashCode() ?: 0)
        result = 31 * result + (launchYear ?: 0)
        result = 31 * result + types.contentHashCode()
        return result
    }
}