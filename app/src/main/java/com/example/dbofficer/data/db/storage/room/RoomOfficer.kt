package com.example.dbofficer.data.db.storage.room

import android.app.Activity
import com.example.dbofficer.data.db.model.OfficerDataModel

class RoomOfficer(activity:Activity): OfficerStorage {

    val db = OfficerDB.getDB(context = activity)
    override fun createNewOfficer(officerDataModel: OfficerDataModel) {
        Thread{
            db.getDao().addOfficer(officerDataModel)
        }.start()
    }
}