package com.example.midasandroid2.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivitySplashBinding
import com.example.midasandroid2.sign.SignInActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash){

    //private val splashViewModel: SplashViewModel by viewModels()

    override fun initView() {
        binding.run {
            GlobalScope.launch {
                delay(900)
                startActivity(Intent(this@SplashActivity,SignInActivity::class.java))
                finish()
            }
        }
    }

    override fun observeEvent() {}

}