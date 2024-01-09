package com.example.dbofficer.data.db.repository.room

import android.content.Context
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.data.db.storage.room.OfficerStorage
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.CreateNewOfficerRepository
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent

class CreateUserRepositoryImplements(private val officerStorage: OfficerStorage): CreateNewOfficerRepository {
    override fun createOfficer(officerModel: OfficerModel, context: Context,saveResultRoom: SingleLiveEvent<Boolean>){
        officerStorage.createNewOfficer(mapToStorage(officerModel),context,saveResultRoom)
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