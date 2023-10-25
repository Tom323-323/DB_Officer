package com.example.dbofficer.data.db.storage.firebase

import com.example.dbofficer.data.db.model.AuthModelData

interface UserStorage {
    fun signIn(autModelData: AuthModelData)

    fun createUserFireBase(autModelData: AuthModelData)
}