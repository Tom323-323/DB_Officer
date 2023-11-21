package com.example.dbofficer.domain.usecase

import com.example.dbofficer.domain.repository.GetAllOfficerFBRepository

class GetAllOfficerFromFireBaseUseCase (val getAllOfficerFBRepository: GetAllOfficerFBRepository){

    fun getAllOfficerFB(){
        getAllOfficerFBRepository.getAllOfficerFB()
    }

}