package com.example.dbofficer.domain.usecase

import android.content.Context
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.CreateNewOfficerRepository
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent

class CreateNewOfficerRoom (private val createNewOfficerRepository: CreateNewOfficerRepository){
    fun createNewOfficer(
        officerModel: OfficerModel,
        context: Context,
        saveResultRoom: SingleLiveEvent<Boolean>
    ){
        createNewOfficerRepository.createOfficer(officerModel,context,saveResultRoom)
    }
}