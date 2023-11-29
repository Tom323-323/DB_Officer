package com.example.dbofficer.data.db.repository.firebase

import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.data.db.storage.firebase.UserStorage
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.SearchOfficerRepository

class SearchOfficerRepositoryImplements(private val userStorage: UserStorage):SearchOfficerRepository {
    override fun searchOfficer(searchOfficer: String):List<OfficerModel> {
        return userStorage.searchOfficer(searchOfficer)
    }
}