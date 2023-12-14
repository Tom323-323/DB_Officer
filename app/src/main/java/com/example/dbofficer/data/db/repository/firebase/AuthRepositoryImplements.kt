package com.example.dbofficer.data.db.repository.firebase

import androidx.lifecycle.MutableLiveData
import com.example.dbofficer.data.db.storage.firebase.UserStorage
import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.domain.repository.AuthRepository
import com.example.dbofficer.domain.model.AuthModel
import com.example.dbofficer.domain.model.OfficerModel

class AuthRepositoryImplements(private val userStorage: UserStorage): AuthRepository {
    override fun signIn(authModel: AuthModel, result: MutableLiveData<Boolean>) {
        userStorage.signIn(mapToStorage(authModel),result)
    }
    override fun createUserFireBase(authModel: AuthModel) {
        userStorage.createUserFireBase(mapToStorage(authModel))
    }
    fun mapToStorage(authModel:AuthModel): AuthModelData {
        return AuthModelData(authModel.email,authModel.password)
    }

    override fun createNewOfficerFB(officerModel: OfficerModel) {
        userStorage.createNewOfficerFB(mapToStorage(officerModel))
    }

    fun mapToStorage(officerModel: OfficerModel): OfficerDataModel {
        return OfficerDataModel(id = null,
            name = officerModel.name,
            major = officerModel.major,
            birthDate = officerModel.birthDate,
            rank = officerModel.rank
        )
    }
}