package com.example.dbofficer.presenter.di

import com.example.dbofficer.presenter.screens.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<AuthViewModel>{
        AuthViewModel(
            signInFirebaseUseCase = get(),
            createUserFirebaseUseCase = get()
        )
    }
}