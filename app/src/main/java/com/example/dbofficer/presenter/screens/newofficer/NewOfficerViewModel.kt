package com.example.dbofficer.presenter.screens.newofficer

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.usecase.CreateNewOfficerFireBase
import com.example.dbofficer.domain.usecase.CreateNewOfficerRoom
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent

class NewOfficerViewModel(private val createNewOfficerRoom: CreateNewOfficerRoom,
                          private val createNewOfficerFB: CreateNewOfficerFireBase
): ViewModel() {

    private var _accountSaveResult = SingleLiveEvent<Boolean>()
    val accountSaveResult get() = _accountSaveResult

    fun createNewOfficer(officerModel: OfficerModel, context: Context){
        createNewOfficerRoom.createNewOfficer(officerModel,context,_accountSaveResult)
    }

    fun createNewOfficerFB(officerModel: OfficerModel){
        createNewOfficerFB.createNewOfficerFB(officerModel,_accountSaveResult)
    }
}