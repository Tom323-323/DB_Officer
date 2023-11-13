package com.example.dbofficer.domain.usecase

import android.content.Context
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.CreateNewOfficerRepository

class CreateNewOfficerRoom (private val createNewOfficerRepository: CreateNewOfficerRepository){
    fun createNewOfficer(officerModel: OfficerModel,context: Context){
        createNewOfficerRepository.createOfficer(officerModel,context)
    }
}