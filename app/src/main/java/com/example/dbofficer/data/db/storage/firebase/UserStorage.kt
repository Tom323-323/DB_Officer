package com.example.dbofficer.data.db.storage.firebase

import androidx.lifecycle.MutableLiveData
import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.domain.model.OfficerModel

interface UserStorage {
    fun signIn(autModelData: AuthModelData, result:MutableLiveData<Boolean>)

    fun createUserFireBase(autModelData: AuthModelData)

    fun createNewOfficerFB(officerDataModel: OfficerDataModel)

    fun searchOfficer(nameOfficerSearch:String):List<OfficerModel>

    fun getAllOfficerFB():List<OfficerModel>
}