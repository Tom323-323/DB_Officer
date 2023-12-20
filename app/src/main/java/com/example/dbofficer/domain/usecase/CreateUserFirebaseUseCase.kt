package com.example.dbofficer.domain.usecase

import com.example.dbofficer.domain.repository.AuthRepository
import com.example.dbofficer.domain.model.AuthModel
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent

class CreateUserFirebaseUseCase (private val authRepository: AuthRepository) {

    fun createUserFireBase(authModel: AuthModel,result: SingleLiveEvent<Boolean>) {
        authRepository.createUserFireBase(authModel,result)
    }
}