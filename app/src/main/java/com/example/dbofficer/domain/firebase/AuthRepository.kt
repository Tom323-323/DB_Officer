package com.example.dbofficer.domain.firebase

import android.app.Activity
import com.example.dbofficer.domain.model.AuthModel

interface AuthRepository {

    fun signIn(authmodel:AuthModel,activity: Activity)

    fun createOfficerFireBase(authmodel:AuthModel,activity: Activity)


}