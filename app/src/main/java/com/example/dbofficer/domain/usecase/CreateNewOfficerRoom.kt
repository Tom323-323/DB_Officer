package com.example.dbofficer.domain.usecase

import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.CreateNewOfficerRepository

class CreateNewOfficerRoom (private val createNewOfficerRepository: CreateNewOfficerRepository){

    fun createNewOfficer(officerModel: OfficerModel){
        createNewOfficerRepository.crateOfficer(officerModel)
    }


}