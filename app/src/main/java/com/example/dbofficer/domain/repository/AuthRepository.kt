package com.example.dbofficer.domain.repository

import androidx.lifecycle.MutableLiveData
import com.example.dbofficer.domain.model.AuthModel
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent

interface AuthRepository {

    fun signIn(authModel:AuthModel,result: SingleLiveEvent<Boolean>)

    fun createUserFireBase(authModel:AuthModel)

    fun createNewOfficerFB(officerModel: OfficerModel)


}