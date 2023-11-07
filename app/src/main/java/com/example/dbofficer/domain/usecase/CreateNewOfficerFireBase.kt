package com.example.dbofficer.domain.usecase

import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.CreateNewOfficerRepository

class CreateNewOfficerFireBase (private val createNewOfficerFireBase: CreateNewOfficerRepository) {
    fun createNewOfficer(officerModel: OfficerModel){
        createNewOfficerFireBase.createOfficer(officerModel)
    }
}