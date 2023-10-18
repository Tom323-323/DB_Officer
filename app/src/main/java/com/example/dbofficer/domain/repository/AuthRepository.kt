package com.example.dbofficer.domain.repository

import android.app.Activity
import com.example.dbofficer.domain.model.AuthModel

interface AuthRepository {

    fun signIn(authmodel:AuthModel)

    fun createUserFireBase(authmodel:AuthModel)


}