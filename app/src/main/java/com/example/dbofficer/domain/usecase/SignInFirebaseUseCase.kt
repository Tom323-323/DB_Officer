package com.example.dbofficer.domain.usecase


import android.app.Activity
import com.example.dbofficer.domain.repository.AuthRepository
import com.example.dbofficer.domain.model.AuthModel


class SignInFirebaseUseCase (private val authRepository: AuthRepository) {


    fun signIn(authModel:AuthModel,activity: Activity) {
        authRepository.signIn(authModel,activity)
    }

}
