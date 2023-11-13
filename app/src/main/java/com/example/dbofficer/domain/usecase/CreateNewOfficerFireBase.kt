package com.example.dbofficer.domain.usecase

import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.AuthRepository

class CreateNewOfficerFireBase (private val createNewOfficerFireBase: AuthRepository) {
    fun createNewOfficerFB(officerModel: OfficerModel){
        createNewOfficerFireBase.createNewOfficerFB(officerModel)
    }
}