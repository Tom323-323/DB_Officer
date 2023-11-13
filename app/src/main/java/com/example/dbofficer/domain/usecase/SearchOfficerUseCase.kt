package com.example.dbofficer.domain.usecase

import com.example.dbofficer.domain.repository.SearchOfficer

class SearchOfficerUseCase (val searchOfficerImp:SearchOfficer){

    fun searchOfficer(nameOfficerSearch:String){
            searchOfficerImp.searchOfficer(nameOfficerSearch)
    }
}