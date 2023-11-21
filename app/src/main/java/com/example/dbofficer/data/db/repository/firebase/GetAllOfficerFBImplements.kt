package com.example.dbofficer.data.db.repository.firebase

import com.example.dbofficer.data.db.storage.firebase.UserStorage
import com.example.dbofficer.domain.repository.GetAllOfficerFBRepository

class GetAllOfficerFBImplements (val userStorage: UserStorage): GetAllOfficerFBRepository{
    override fun getAllOfficerFB() {
        userStorage.getAllOfficerFB()
    }
}