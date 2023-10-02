package com.example.dbofficer.data.db

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dbofficer.data.db.dao.OfficerDAO
import com.example.dbofficer.domain.model.OfficerModel

@Database(entities = [OfficerModel::class], version = 1)            // We have function (4) ver.1 ------->  1. ADD, 2. DELETE, 3.SEARCH, 4. UPDATE
abstract class OfficerDB:RoomDatabase () {
    abstract fun getDao():Dao
    companion object{
        fun getDB (context: Context): OfficerDB{

            return Room.databaseBuilder(
                context.applicationContext,
                OfficerDB::class.java,
                "officer.db"
            ).build()
        }
    }
}