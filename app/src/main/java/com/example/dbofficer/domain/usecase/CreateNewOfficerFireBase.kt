package com.example.dbofficer.domain.usecase

import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.AuthRepository

class CreateNewOfficerFireBase (private val authRepository: AuthRepository) {
    fun createNewOfficerFB(officerModel: OfficerModel){
        authRepository.createNewOfficerFB(officerModel)
    }
}