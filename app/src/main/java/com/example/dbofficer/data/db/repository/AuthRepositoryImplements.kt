package com.example.dbofficer.data.db.repository

import android.app.Activity
import com.example.dbofficer.data.db.storage.UserStorage
import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.domain.firebase.AuthRepository
import com.example.dbofficer.domain.model.AuthModel

class AuthRepositoryImplements(private val officerStorage: UserStorage): AuthRepository {
    override fun signIn(authmodel: AuthModel, activity: Activity) {
        officerStorage.signIn(mapToStorage(authmodel),activity)
    }

    override fun createUserFireBase(authmodel: AuthModel, activity: Activity) {
        officerStorage.createUserFireBase(mapToStorage(authmodel),activity)
    }

    fun mapToStorage(authModel:AuthModel): AuthModelData {
        return AuthModelData(authModel.email,authModel.password)

    }


}