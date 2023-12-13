package com.example.dbofficer.presenter.screens.auth


import androidx.lifecycle.ViewModel
import com.example.dbofficer.domain.model.AuthModel
import com.example.dbofficer.domain.usecase.CreateUserFirebaseUseCase
import com.example.dbofficer.domain.usecase.SignInFirebaseUseCase

class AuthViewModel(private val signInFirebaseUseCase: SignInFirebaseUseCase,
                    private val createUserFirebaseUseCase: CreateUserFirebaseUseCase): ViewModel () {
    fun signIn(authModel:AuthModel):String{
        return signInFirebaseUseCase.signIn(authModel)
    }

    fun creteNewUser(authModel:AuthModel){
        createUserFirebaseUseCase.createUserFireBase(authModel)
    }
}