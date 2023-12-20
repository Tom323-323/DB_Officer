package com.example.dbofficer.data.db.storage.firebase

import androidx.lifecycle.MutableLiveData
import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent

interface UserStorage {
    fun signIn(autModelData: AuthModelData, result:SingleLiveEvent<Boolean>)

    fun createUserFireBase(autModelData: AuthModelData,result:SingleLiveEvent<Boolean>)

    fun createNewOfficerFB(officerDataModel: OfficerDataModel)

    fun searchOfficer(nameOfficerSearch:String):List<OfficerModel>

    fun getAllOfficerFB():List<OfficerModel>
}