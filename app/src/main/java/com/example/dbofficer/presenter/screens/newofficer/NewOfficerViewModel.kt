package com.example.dbofficer.presenter.screens.newofficer

import androidx.lifecycle.ViewModel
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.usecase.CreateNewOfficerRoom

class NewOfficerViewModel(private val createNewOfficerRoom: CreateNewOfficerRoom): ViewModel() {
    fun createNewOfficer(officerModel: OfficerModel){
        createNewOfficerRoom.createNewOfficer(officerModel)
    }
}