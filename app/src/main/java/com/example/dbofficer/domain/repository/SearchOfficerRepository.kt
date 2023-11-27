package com.example.dbofficer.domain.repository

import com.example.dbofficer.data.db.model.OfficerDataModel

interface SearchOfficerRepository {

    fun searchOfficer(searchOfficer:String):List<OfficerDataModel>
}