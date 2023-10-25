package com.example.dbofficer.presenter.di

import com.example.dbofficer.MainActivity
import com.example.dbofficer.data.db.repository.firebase.AuthRepositoryImplements
import com.example.dbofficer.data.db.storage.firebase.FirebaseUser
import com.example.dbofficer.data.db.storage.firebase.UserStorage
import com.example.dbofficer.domain.repository.AuthRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        FirebaseUser(activity = MainActivity())
    }

    single<AuthRepository> {
        AuthRepositoryImplements(officerStorage = get())
    }
}