package com.example.midasandroid2.sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivitySignInBinding
import com.example.midasandroid2.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in){

    private val signInViewModel: SignInViewModel by viewModels()

    override fun initView() {
        binding.run {
            btnLogin.setOnClickListener {
                startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                finish()
            }
            btnSignUp.setOnClickListener {
                startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
                finish()
            }
        }

    }

    override fun observeEvent() {}

}