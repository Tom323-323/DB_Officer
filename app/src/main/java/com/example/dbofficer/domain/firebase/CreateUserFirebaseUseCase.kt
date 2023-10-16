package com.example.dbofficer.domain.firebase

import android.app.Activity
import com.example.dbofficer.domain.model.AuthModel

class CreateUserFirebaseUseCase (private val authRepository: AuthRepository) {


    fun createUserFireBase(authModel: AuthModel,context: Activity) {
        authRepository.createUserFireBase(authModel,context)
    }
}