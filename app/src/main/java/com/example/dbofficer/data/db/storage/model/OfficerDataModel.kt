package com.example.dbofficer.data.db.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "officer_model")
data class OfficerDataModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo (name = "name")
    var name: String,
    @ColumnInfo (name = "departament")
    var major: String,
    @ColumnInfo (name = "years_in_system")
    var birthDate:String,
    @ColumnInfo (name = "rank")
    var rank: String
)