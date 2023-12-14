package com.example.dbofficer.presenter.screens.auth


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dbofficer.domain.model.AuthModel
import com.example.dbofficer.domain.usecase.CreateUserFirebaseUseCase
import com.example.dbofficer.domain.usecase.SignInFirebaseUseCase

class AuthViewModel(private val signInFirebaseUseCase: SignInFirebaseUseCase,
                    private val createUserFirebaseUseCase: CreateUserFirebaseUseCase): ViewModel () {

    private var _accountCreationResult = MutableLiveData<Boolean>()
    val accountCreationResult get() = _accountCreationResult
    fun signIn(authModel:AuthModel,result:MutableLiveData<Boolean>){
        signInFirebaseUseCase.signIn(authModel, _accountCreationResult)
    }

    fun creteNewUser(authModel:AuthModel){
        createUserFirebaseUseCase.createUserFireBase(authModel)
    }
}