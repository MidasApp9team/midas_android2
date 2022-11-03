package com.example.midasandroid2.calendar

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.example.midasandroid2.databinding.DialogFixBinding

class DialogFix(
    context: Context,
    name: String
): Dialog(context){

    val name = name
    private lateinit var binding: DialogFixBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogFixBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.tvName.text = name

        binding.run {
            btnChange.setOnClickListener {
                tvStartTime.text = "출근 시간 " + etIn.text.toString()
                tvEndTime.text = "퇴근 시간 " + etOut.text.toString()
            }
        }
    }
}