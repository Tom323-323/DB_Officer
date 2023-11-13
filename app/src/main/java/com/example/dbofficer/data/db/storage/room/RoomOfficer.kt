package com.example.dbofficer.data.db.storage.room

import android.app.Activity
import android.content.Context
import com.example.dbofficer.data.db.model.OfficerDataModel

class RoomOfficer(): OfficerStorage {

    override fun createNewOfficer(officerDataModel: OfficerDataModel, context: Context) {
        val db = OfficerDB.getDB(context = context)
        Thread{
            db.getDao().addOfficer(officerDataModel)
        }.start()
    }
}