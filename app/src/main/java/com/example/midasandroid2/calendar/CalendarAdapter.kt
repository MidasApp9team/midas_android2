package com.example.midasandroid2.calendar

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager.LayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.example.midasandroid2.R
import com.example.midasandroid2.databinding.ItemBinding

class CalendarAdapter(private val calendarList: List<CalendarData>, private val calendarActivity: CalendarActivity): RecyclerView.Adapter<CalendarAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return CustomViewHolder(ItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.binding.tvName.text = calendarList[position].name
        holder.binding.view.layoutParams = ViewGroup.LayoutParams(LayoutParams(calendarList[position].persent*10,ViewGroup.LayoutParams.MATCH_PARENT))
        holder.binding.view.layoutParams.width = calendarList[position].persent*10
        holder.itemView.setOnClickListener {
            calendarActivity.goFix(holder.binding.tvName.text.toString())
        }
    }

    override fun getItemCount(): Int = calendarList.size

    class CustomViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

}