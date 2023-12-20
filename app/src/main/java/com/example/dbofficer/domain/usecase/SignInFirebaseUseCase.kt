package com.example.dbofficer.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.dbofficer.domain.repository.AuthRepository
import com.example.dbofficer.domain.model.AuthModel
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent

class SignInFirebaseUseCase (private val authRepository: AuthRepository) {

    fun signIn(authModel:AuthModel, result: SingleLiveEvent<Boolean>){
        authRepository.signIn(authModel, result)
    }

}

