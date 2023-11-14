package com.example.dbofficer.presenter.di

import com.example.dbofficer.MainActivity
import com.example.dbofficer.data.db.repository.firebase.AuthRepositoryImplements
import com.example.dbofficer.data.db.repository.firebase.SearchOfficerRepositoryImplements
import com.example.dbofficer.data.db.repository.room.CreateUserRepositoryImplements
import com.example.dbofficer.data.db.storage.firebase.FirebaseUser
import com.example.dbofficer.data.db.storage.firebase.UserStorage
import com.example.dbofficer.data.db.storage.room.OfficerStorage
import com.example.dbofficer.data.db.storage.room.RoomOfficer
import com.example.dbofficer.domain.repository.AuthRepository
import com.example.dbofficer.domain.repository.CreateNewOfficerRepository
import com.example.dbofficer.domain.repository.SearchOfficerRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        FirebaseUser(activity = MainActivity())
    }

    single<OfficerStorage> {
        RoomOfficer()
    }

    single<AuthRepository> {
        AuthRepositoryImplements(userStorage = get())
    }

    single<SearchOfficerRepository> {
        SearchOfficerRepositoryImplements(userStorage = get())
    }

    single<CreateNewOfficerRepository> {
        CreateUserRepositoryImplements(officerStorage = get())
    }

}