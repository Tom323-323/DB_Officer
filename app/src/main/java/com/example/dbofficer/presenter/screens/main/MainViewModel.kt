package com.example.dbofficer.presenter.screens.main

import androidx.lifecycle.ViewModel
import com.example.dbofficer.domain.usecase.GetAllOfficerFromFireBaseUseCase
import com.example.dbofficer.domain.usecase.SearchOfficerUseCase

class MainViewModel (private val searchOfficerUseCase: SearchOfficerUseCase,
                    private val getAllOfficerFireBase:GetAllOfficerFromFireBaseUseCase): ViewModel () {

//    val data: MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }

    fun searchOfficer(nameOfficer:String){
        searchOfficerUseCase.searchOfficer(nameOfficer)
    }

    fun getAllOfficerFromFireBase(){
        getAllOfficerFireBase.getAllOfficerFB()
    }

}