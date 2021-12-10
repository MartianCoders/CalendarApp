package com.example.calendarapp.activities.calendarActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calendarapp.R
import com.example.calendarapp.model.Date
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var dataList: List<Date> = ArrayList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val calendarMonthText: TextView = itemView.findViewById(R.id.calendar_month_text)
        private val calendarDayText: TextView = itemView.findViewById(R.id.calendar_day_text)
        private val nameText: TextView = itemView.findViewById(R.id.name_text)
        private val nameCountryText: TextView = itemView.findViewById(R.id.name_country_text)

        fun bind(date: Date) {
            nameText.text = date.name
            nameCountryText.text = date.localName

            val calendar = LocalDate.parse(date.date).format(DateTimeFormatter.ofPattern("dd-LLL-yyyy")).split('-')

            calendarMonthText.text = calendar[1].uppercase()
            calendarDayText.text = calendar[0]

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.calendar_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data: Date = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateList(list: List<Date>) {
        this.dataList = list
        notifyDataSetChanged()
    }
}