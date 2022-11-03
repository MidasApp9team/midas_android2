package com.example.midasandroid2.main

import androidx.lifecycle.ViewModel
import com.example.midasandroid2.base.BaseViewModel

class MainViewModel(
): BaseViewModel<MainViewModel.Event>() {

    sealed class Event{

    }
}