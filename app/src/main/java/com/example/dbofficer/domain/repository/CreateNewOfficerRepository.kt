package com.example.dbofficer.domain.repository

import android.content.Context
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent

interface CreateNewOfficerRepository {
    fun createOfficer(officerModel: OfficerModel, context: Context,saveResultRoom: SingleLiveEvent<Boolean>)

}