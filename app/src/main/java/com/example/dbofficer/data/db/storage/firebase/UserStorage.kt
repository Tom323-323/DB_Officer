package com.example.dbofficer.data.db.storage.firebase

import android.app.Activity
import com.example.dbofficer.data.db.model.AuthModelData

interface UserStorage {

    fun signIn(autModelData: AuthModelData,activity: Activity)

    fun createUserFireBase(autModelData:AuthModelData,activity: Activity)
}