package com.example.dbofficer.presenter.di

import com.example.dbofficer.MainActivity
import com.example.dbofficer.data.db.storage.firebase.FirebaseUser
import com.example.dbofficer.presenter.screens.auth.AuthViewModel
import com.example.dbofficer.presenter.screens.main.MainViewModel
import com.example.dbofficer.presenter.screens.newofficer.NewOfficerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<AuthViewModel>{
        AuthViewModel(
            signInFirebaseUseCase = get(),
            createUserFirebaseUseCase = get()
        )
    }

    viewModel<MainViewModel>{
        MainViewModel(
            searchOfficerUseCase = get(),
            getAllOfficerFireBase = get()
        )
    }

    viewModel<NewOfficerViewModel>{
        NewOfficerViewModel(
            createNewOfficerRoom = get(),
            createNewOfficerFB = get()
        )
    }
}