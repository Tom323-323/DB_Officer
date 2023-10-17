package com.example.dbofficer.data.db.storage.room

import com.example.dbofficer.data.db.model.OfficerDataModel

interface OfficerStorage {
    fun createNewOfficer(officerDataModel: OfficerDataModel)
}