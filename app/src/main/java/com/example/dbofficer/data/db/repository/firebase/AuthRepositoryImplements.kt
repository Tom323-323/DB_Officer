package com.example.dbofficer.data.db.repository.firebase

import com.example.dbofficer.data.db.storage.firebase.UserStorage
import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.domain.repository.AuthRepository
import com.example.dbofficer.domain.model.AuthModel

class AuthRepositoryImplements(private val officerStorage: UserStorage): AuthRepository {
    override fun signIn(authmodel: AuthModel) {
        officerStorage.signIn(mapToStorage(authmodel))
    }
    override fun createUserFireBase(authmodel: AuthModel) {
        officerStorage.createUserFireBase(mapToStorage(authmodel))
    }
    fun mapToStorage(authModel:AuthModel): AuthModelData {
        return AuthModelData(authModel.email,authModel.password)

    }
}