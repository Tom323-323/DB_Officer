package com.example.dbofficer.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.dbofficer.domain.model.AuthModel
import com.example.dbofficer.domain.model.OfficerModel

interface AuthRepository {

    fun signIn(authModel:AuthModel,result: MutableLiveData<Boolean>)

    fun createUserFireBase(authModel:AuthModel)

    fun createNewOfficerFB(officerModel: OfficerModel)


}