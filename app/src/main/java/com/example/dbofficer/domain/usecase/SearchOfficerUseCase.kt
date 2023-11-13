package com.example.dbofficer.domain.usecase

import com.example.dbofficer.domain.repository.SearchOfficerRepository

class SearchOfficerUseCase (val searchOfficerRepositoryImp:SearchOfficerRepository){

    fun searchOfficer(nameOfficerSearch:String){
            searchOfficerRepositoryImp.searchOfficer(nameOfficerSearch)
    }
}