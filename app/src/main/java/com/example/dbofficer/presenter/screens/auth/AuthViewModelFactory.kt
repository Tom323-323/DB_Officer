package com.example.dbofficer.presenter.screens.auth

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dbofficer.data.db.repository.firebase.AuthRepositoryImplements
import com.example.dbofficer.data.db.storage.firebase.FirebaseUser
import com.example.dbofficer.domain.usecase.CreateUserFirebaseUseCase
import com.example.dbofficer.domain.usecase.SignInFirebaseUseCase

class AuthViewModelFactory (activity: Activity): ViewModelProvider.Factory{

    private val authRepository by lazy { AuthRepositoryImplements(FirebaseUser(activity = activity)) }
    private val signIn by lazy { SignInFirebaseUseCase(authRepository) }
    private val createUser by lazy { CreateUserFirebaseUseCase(authRepository) }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(signInFirebaseUseCase = signIn,
                             createUserFirebaseUseCase = createUser
        ) as T
    }
}