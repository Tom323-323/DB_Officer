package com.example.dbofficer.domain.usecase

import com.example.dbofficer.data.db.repository.firebase.AuthRepositoryImplements
import com.example.dbofficer.domain.model.OfficerModel

class CreateNewOfficerFireBase (private val createNewOfficerFireBase: AuthRepositoryImplements) {
    fun createNewOfficerFB(officerModel: OfficerModel){
        createNewOfficerFireBase.createNewOfficerFB(officerModel)
    }
}