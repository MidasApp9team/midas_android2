package com.example.midasandroid2.main

import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivityMainBinding
import com.example.midasandroid2.main.compose.MainComposeHelper
import com.example.midasandroid2.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Modifier

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main){

    private val mainViewModel: MainViewModel by viewModels()

    override fun initView() {
        binding.run {
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