package com.example.dbofficer.presenter.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel () {
    val data: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}