package com.example.dbofficer.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.dbofficer.domain.repository.AuthRepository
import com.example.dbofficer.domain.model.AuthModel

class SignInFirebaseUseCase (private val authRepository: AuthRepository) {

    fun signIn(authModel:AuthModel, result:MutableLiveData<Boolean>){
        authRepository.signIn(authModel, result)
    }

}

