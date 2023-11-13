package com.example.dbofficer.presenter.screens.newofficer

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.usecase.CreateNewOfficerFireBase
import com.example.dbofficer.domain.usecase.CreateNewOfficerRoom

class NewOfficerViewModel(private val createNewOfficerRoom: CreateNewOfficerRoom,
                          private val createNewOfficerFB: CreateNewOfficerFireBase
): ViewModel() {
    fun createNewOfficer(officerModel: OfficerModel, context: Context){
        createNewOfficerRoom.createNewOfficer(officerModel,context)
    }

    fun createNewOfficerFB(officerModel: OfficerModel){
        createNewOfficerFB.createNewOfficerFB(officerModel)
    }
}