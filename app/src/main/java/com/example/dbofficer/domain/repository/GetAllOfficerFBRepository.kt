package com.example.dbofficer.domain.repository

import com.example.dbofficer.data.db.model.OfficerDataModel

interface GetAllOfficerFBRepository {

    fun getAllOfficerFB():List<OfficerDataModel>

}