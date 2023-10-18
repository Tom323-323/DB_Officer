package com.example.dbofficer.presenter.screens.newofficer

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dbofficer.data.db.repository.room.CreateUserRepositoryImplements
import com.example.dbofficer.data.db.storage.room.RoomOfficer
import com.example.dbofficer.domain.usecase.CreateNewOfficerRoom

class NewOfficerViewModelFactory(activity: Activity):ViewModelProvider.Factory {

    private val createNewOfficerRepository by lazy { CreateUserRepositoryImplements(RoomOfficer(activity = activity)) }
    private val createNewOfficerRoom by lazy { CreateNewOfficerRoom(createNewOfficerRepository) }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewOfficerViewModel(createNewOfficerRoom) as T
    }
}