package com.example.dbofficer.domain.repository

import com.example.dbofficer.domain.model.AuthModel
import com.example.dbofficer.domain.model.OfficerModel

interface AuthRepository {

    suspend fun signIn(authModel:AuthModel):String

    fun createUserFireBase(authModel:AuthModel)

    fun createNewOfficerFB(officerModel: OfficerModel)


}