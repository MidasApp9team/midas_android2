package com.example.midasandroid2.calendar

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivityCalendarBinding

class CalendarActivity : BaseActivity<ActivityCalendarBinding>(R.layout.activity_calendar){

    val rvList = (0..100).map {
        CalendarData("직원${it}",it) }.toList()

    override fun initView() {
        binding.run {
            btnBack.setOnClickListener {
                finish()
            }

            rv.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
            rv.setHasFixedSize(true)
            rv.adapter = CalendarAdapter(rvList,this@CalendarActivity)
        }
    }

    override fun observeEvent() {}

    fun goFix(name: String){
        DialogFix(this, name).show()
    }

}