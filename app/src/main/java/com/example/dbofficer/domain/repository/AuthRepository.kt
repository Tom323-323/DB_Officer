package com.example.dbofficer.domain.repository

import com.example.dbofficer.domain.model.AuthModel
import com.example.dbofficer.domain.model.OfficerModel

interface AuthRepository {

    fun signIn(authModel:AuthModel):Boolean

    fun createUserFireBase(authModel:AuthModel)

    fun createNewOfficerFB(officerModel: OfficerModel)


}