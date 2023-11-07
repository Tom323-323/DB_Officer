package com.example.dbofficer.data.db.repository.firebase

import com.example.dbofficer.data.db.storage.firebase.UserStorage
import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.domain.repository.AuthRepository
import com.example.dbofficer.domain.model.AuthModel
import com.example.dbofficer.domain.model.OfficerModel

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

    override fun createNewOfficerFB(officerModel: OfficerModel) {
        officerStorage.createNewOfficerFB(mapToStorage(officerModel))
    }

    fun mapToStorage(officerModel: OfficerModel): OfficerDataModel {
        return OfficerDataModel(id = null,
            name = officerModel.name,
            major = officerModel.major,
            birthDate = officerModel.birthDate,
            rank = officerModel.rank )
    }
}