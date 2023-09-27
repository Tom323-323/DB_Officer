package com.example.dbofficer.data.db.repository

import com.example.dbofficer.domain.model.OfficerModel

interface OfficerRepository {

    suspend fun search(name: String)

    suspend fun delete(officerModel: OfficerModel)

    suspend fun add(officerModel: OfficerModel)

    suspend fun update (officerModel: OfficerModel)
}