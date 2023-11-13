package com.example.dbofficer.presenter.di

import com.example.dbofficer.domain.usecase.CreateUserFirebaseUseCase
import com.example.dbofficer.domain.usecase.SearchOfficerUseCase
import com.example.dbofficer.domain.usecase.SignInFirebaseUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<SignInFirebaseUseCase> {
        SignInFirebaseUseCase(authRepository = get())
    }

    factory<CreateUserFirebaseUseCase> {
        CreateUserFirebaseUseCase(authRepository = get())
    }

    factory<SearchOfficerUseCase> {
        SearchOfficerUseCase(searchOfficerImp = get())
    }

}