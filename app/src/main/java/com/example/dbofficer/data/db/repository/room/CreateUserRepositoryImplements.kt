package com.example.dbofficer.data.db.repository.room

import android.content.Context
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.data.db.storage.room.OfficerStorage
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.CreateNewOfficerRepository

class CreateUserRepositoryImplements(private val officerStorage: OfficerStorage): CreateNewOfficerRepository {
    override fun createOfficer(officerModel: OfficerModel, context: Context){
        officerStorage.createNewOfficer(mapToStorage(officerModel),context)
    }


    fun mapToStorage(officerModel: OfficerModel): OfficerDataModel {
        return OfficerDataModel(id = null,
                                name = officerModel.name,
                                major = officerModel.major,
                                birthDate = officerModel.birthDate,
                                rank = officerModel.rank )
    }
}