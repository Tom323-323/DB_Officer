package com.example.dbofficer.domain.firebase

import android.app.Activity
import com.example.dbofficer.domain.model.AuthModel

class CreateOfficerFirebaseUseCase (private val authRepository: AuthRepository) {

    fun updateUI(){
        //TODOOOOOO!!!!
    }

    fun createOfficerFireBase(authModel: AuthModel,context: Activity) {
        authRepository.createOfficerFireBase(authModel,context)
    }
}