package com.example.dbofficer.data.db.repository

import com.example.dbofficer.data.db.dao.OfficerDAO
import com.example.dbofficer.domain.model.OfficerModel

class OfficerRealization(private val dao: OfficerDAO): OfficerRepository {


    override suspend fun search(name: String) {

    }

    override suspend fun delete(officerModel: OfficerModel) {

    }

    override suspend fun add(officerModel: OfficerModel) {

    }

    override suspend fun update(officerModel: OfficerModel) {

    }
}