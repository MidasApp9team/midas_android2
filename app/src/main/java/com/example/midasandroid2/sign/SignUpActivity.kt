package com.example.midasandroid2.sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midasandroid2.R
import com.example.midasandroid2.base.BaseActivity
import com.example.midasandroid2.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up){

    override fun initView() {
        binding.run {
            btnLogin.setOnClickListener {
                startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
            }
            btnSignUp.setOnClickListener {
                startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
            }
        }
    }

    override fun observeEvent() {}

}