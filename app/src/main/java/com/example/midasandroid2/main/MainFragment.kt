package com.example.midasandroid2.main

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.example.domain.entity.DateEntity
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseFragment
import com.example.midasandroid2.calendar.CalendarActivity
import com.example.midasandroid2.databinding.FragmentMainBinding
import com.example.midasandroid2.main.compose.MainComposeHelper
import com.example.midasandroid2.main.compose.date
import com.example.midasandroid2.util.owner
import com.example.midasandroid2.util.start_time
import com.example.midasandroid2.util.stop_time
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main){

    private val mainViewModel: MainViewModel by viewModels()

    override fun initView() {

        val mainActivity =  activity as MainActivity
        val name = if (owner) "관리자" else "사용자"

        binding.run {
            tvName.text = name+"님"

            if(owner){
                btnCalendar.visibility = View.VISIBLE
            }

            btnCalendar.setOnClickListener {
                startActivity(Intent(requireContext(), CalendarActivity::class.java))
            }

            composeView.apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                setContent {
                    MainComposeHelper(mainActivity)
                }
            }

            btnPut.setOnClickListener {
                val date = date()
                Log.d("TAG", "initView: $date")
                mainViewModel.putDate(
                    DateEntity(
                        start_time = "$start_time:00",
                        stop_time = "$stop_time:00",
                        date = date
                    )
                )
            }
        }
    }

    override fun observeEvent() {
        mainViewModel.run {
            success.observe(this@MainFragment){
                showToast("전송 성공")
            }
            fail.observe(this@MainFragment){
                showToast("실패")
            }
        }
    }
}