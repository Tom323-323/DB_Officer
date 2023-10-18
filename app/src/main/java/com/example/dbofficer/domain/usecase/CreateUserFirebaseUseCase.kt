package com.example.dbofficer.domain.usecase

import android.app.Activity
import com.example.dbofficer.domain.repository.AuthRepository
import com.example.dbofficer.domain.model.AuthModel

class CreateUserFirebaseUseCase (private val authRepository: AuthRepository) {

    fun createUserFireBase(authModel: AuthModel) {
        authRepository.createUserFireBase(authModel)
    }
}