package com.example.dbofficer.data.db.storage.room

import android.content.Context
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent

interface OfficerStorage {
    fun createNewOfficer(officerDataModel: OfficerDataModel, context: Context,saveResultRoom: SingleLiveEvent<Boolean>)

}