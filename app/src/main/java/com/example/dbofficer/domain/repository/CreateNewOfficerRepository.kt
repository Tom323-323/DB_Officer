package com.example.dbofficer.domain.repository

import com.example.dbofficer.domain.model.OfficerModel

interface CreateNewOfficerRepository {
    fun createOfficer(officerModel:OfficerModel)

}