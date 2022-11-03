package com.example.midasandroid2.main

import androidx.activity.viewModels
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivityMainBinding
import com.example.midasandroid2.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main){

    private val mainViewModel: MainViewModel by viewModels()

    override fun initView() {

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