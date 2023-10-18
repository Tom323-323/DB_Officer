package com.example.dbofficer.data.db.repository.room

import com.example.dbofficer.data.db.storage.model.OfficerDataModel
import com.example.dbofficer.data.db.storage.room.OfficerStorage
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.CreateNewOfficerRepository

class CreateUserRepositoryImplements(private val officerStorage: OfficerStorage): CreateNewOfficerRepository {
    override fun crateOfficer(officerModel: OfficerModel){
        officerStorage.createNewOfficer(mapToStorage(officerModel))
    }

    fun mapToStorage(officerModel: OfficerModel): OfficerDataModel {
        return OfficerDataModel(id = null,
                                name = officerModel.name,
                                major = officerModel.major,
                                birthDate = officerModel.birthDate,
                                rank = officerModel.rank )
    }
}