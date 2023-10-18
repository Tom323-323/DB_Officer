package com.example.dbofficer.data.db.storage.firebase

import android.app.Activity
import com.example.dbofficer.data.db.storage.model.AuthModelData

interface UserStorage {
    fun signIn(autModelData: AuthModelData)

    fun createUserFireBase(autModelData: AuthModelData)
}