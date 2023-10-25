package com.example.dbofficer.domain.repository

import com.example.dbofficer.domain.model.AuthModel

interface AuthRepository {

    fun signIn(authModel:AuthModel)

    fun createUserFireBase(authModel:AuthModel)


}