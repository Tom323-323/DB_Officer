package com.example.dbofficer.data.db.repository.firebase

import com.example.dbofficer.data.db.storage.firebase.UserStorage
import com.example.dbofficer.domain.repository.SearchOfficer

class SearchOfficerImplements(private val userStorage: UserStorage):SearchOfficer {
    override fun searchOfficer(searchOfficer: String) {
        userStorage.searchOfficer(searchOfficer)
    }
}