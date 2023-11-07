package com.example.dbofficer.presenter.screens.newofficer

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dbofficer.data.db.repository.firebase.AuthRepositoryImplements
import com.example.dbofficer.data.db.repository.room.CreateUserRepositoryImplements
import com.example.dbofficer.data.db.storage.firebase.FirebaseUser
import com.example.dbofficer.data.db.storage.room.RoomOfficer
import com.example.dbofficer.domain.usecase.CreateNewOfficerFireBase
import com.example.dbofficer.domain.usecase.CreateNewOfficerRoom

class NewOfficerViewModelFactory(activity: Activity):ViewModelProvider.Factory {

    private val createNewOfficerRepository by lazy { CreateUserRepositoryImplements(RoomOfficer(activity = activity)) }
    private val createNewOfficerFBRep by lazy { AuthRepositoryImplements(FirebaseUser(activity = activity))}

    private val createNewOfficerRoom by lazy { CreateNewOfficerRoom(createNewOfficerRepository) }
    private val createNewOfficerFB by lazy {CreateNewOfficerFireBase(createNewOfficerFBRep)}
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewOfficerViewModel(createNewOfficerRoom, createNewOfficerFB) as T
    }
}