package com.example.dbofficer.domain.usecase

import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.domain.repository.SearchOfficerRepository

class SearchOfficerUseCase (val searchOfficerRepositoryImp:SearchOfficerRepository){

    fun searchOfficer(nameOfficerSearch:String):List<OfficerDataModel>{
            return searchOfficerRepositoryImp.searchOfficer(nameOfficerSearch)
    }
}