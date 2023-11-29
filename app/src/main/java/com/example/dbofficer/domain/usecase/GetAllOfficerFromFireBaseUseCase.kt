package com.example.dbofficer.domain.usecase

import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.repository.GetAllOfficerFBRepository

class GetAllOfficerFromFireBaseUseCase (val getAllOfficerFBRepository: GetAllOfficerFBRepository){

    fun getAllOfficerFB():List<OfficerModel>{
        return getAllOfficerFBRepository.getAllOfficerFB()
    }

}