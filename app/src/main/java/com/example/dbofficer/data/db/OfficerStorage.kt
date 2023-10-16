package com.example.dbofficer.data.db

import android.app.Activity
import com.example.dbofficer.data.db.model.AuthModelData

interface OfficerStorage {

    fun signIn(autModelData: AuthModelData,activity: Activity)

    fun createOfficerFireBase(autModelData:AuthModelData,activity: Activity)
}