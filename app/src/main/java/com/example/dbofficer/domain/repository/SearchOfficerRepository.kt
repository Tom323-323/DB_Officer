package com.example.dbofficer.domain.repository

import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.domain.model.OfficerModel

interface SearchOfficerRepository {

    fun searchOfficer(searchOfficer:String):List<OfficerModel>
}