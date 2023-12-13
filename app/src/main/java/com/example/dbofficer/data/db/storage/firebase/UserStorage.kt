package com.example.dbofficer.data.db.storage.firebase

import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.domain.model.OfficerModel

interface UserStorage {
    fun signIn(autModelData: AuthModelData):String

    fun createUserFireBase(autModelData: AuthModelData)

    fun createNewOfficerFB(officerDataModel: OfficerDataModel)

    fun searchOfficer(nameOfficerSearch:String):List<OfficerModel>

    fun getAllOfficerFB():List<OfficerModel>
}