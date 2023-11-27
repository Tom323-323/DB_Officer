package com.example.dbofficer.data.db.storage.firebase

import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.data.db.model.OfficerDataModel

interface UserStorage {
    fun signIn(autModelData: AuthModelData)

    fun createUserFireBase(autModelData: AuthModelData)

    fun createNewOfficerFB(officerDataModel: OfficerDataModel)

    fun searchOfficer(nameOfficerSearch:String)

    fun getAllOfficerFB():List<OfficerDataModel>
}