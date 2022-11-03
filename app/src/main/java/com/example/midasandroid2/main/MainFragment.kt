package com.example.midasandroid2.main

import android.content.Intent
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseFragment
import com.example.midasandroid2.calendar.CalendarActivity
import com.example.midasandroid2.databinding.FragmentMainBinding
import com.example.midasandroid2.main.compose.MainComposeHelper
import com.example.midasandroid2.util.owner
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main){


    override fun initView() {

        val mainActivity =  activity as MainActivity
        val name = if (owner) "관리자" else "사용자"

        binding.run {
            binding.tvName.text = name+"님"

            btnCalendar.setOnClickListener {
                startActivity(Intent(requireContext(), CalendarActivity::class.java))
            }

            composeView.apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                setContent {
                    MainComposeHelper(mainActivity)
                }
            }
        }
    }

    override fun observeEvent() {

    }
}