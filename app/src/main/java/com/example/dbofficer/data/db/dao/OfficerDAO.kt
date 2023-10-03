package com.example.dbofficer.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.dbofficer.domain.model.OfficerModel
import kotlinx.coroutines.flow.Flow

@Dao
interface OfficerDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // need fix conflict strategy!!!
    fun addOfficer(officerModel: OfficerModel)

    @Delete
    fun deleteOfficer (officerModel: OfficerModel)

    @Query("SELECT * from  officer_model")                  //Test function get all Officer. Need fix search (  fun searchOfficer (name: String): Flow<List<OfficerModel>>  )
    fun searchOfficer (): Flow<List<OfficerModel>>

    @Update
    fun updateOfficer (officerModel: OfficerModel)

}