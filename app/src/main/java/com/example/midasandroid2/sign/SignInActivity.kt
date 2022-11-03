package com.example.midasandroid2.sign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivitySignInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in){

    private val signInViewModel: SignInViewModel by viewModels()

    override fun initView() {

    }

    override fun observeEvent() {}

}