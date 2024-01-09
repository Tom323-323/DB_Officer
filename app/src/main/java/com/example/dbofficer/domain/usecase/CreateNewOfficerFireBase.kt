package com.example.dbofficer.domain.usecase

import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.AuthRepository
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent

class CreateNewOfficerFireBase (private val authRepository: AuthRepository) {
    fun createNewOfficerFB(officerModel: OfficerModel, saveResultFireBase: SingleLiveEvent<Boolean>){
        authRepository.createNewOfficerFB(officerModel,saveResultFireBase)
    }
}