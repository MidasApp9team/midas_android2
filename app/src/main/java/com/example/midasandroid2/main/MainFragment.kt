package com.example.midasandroid2.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseFragment
import com.example.midasandroid2.calendar.CalendarActivity
import com.example.midasandroid2.databinding.FragmentMainBinding
import com.example.midasandroid2.main.compose.MainComposeHelper
import com.example.midasandroid2.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main){

    private val mainViewModel: MainViewModel by viewModels()

    override fun initView() {
        binding.run {
            btnCalendar.setOnClickListener {
                startActivity(Intent(requireContext(), CalendarActivity::class.java))
            }

            composeView.apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                setContent {
                    MainComposeHelper()
                }
            }
        }
    }

    override fun observeEvent() {
        repeatOnStarted {
            mainViewModel.eventFlow.collect {
                when(it){

                }
            }
        }
    }
}