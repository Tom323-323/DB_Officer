package com.example.dbofficer.domain.usecase

import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.domain.repository.GetAllOfficerFBRepository

class GetAllOfficerFromFireBaseUseCase (val getAllOfficerFBRepository: GetAllOfficerFBRepository){

    fun getAllOfficerFB():List<OfficerDataModel>{
        return getAllOfficerFBRepository.getAllOfficerFB()
    }

}