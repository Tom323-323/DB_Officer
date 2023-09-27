package com.example.dbofficer.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "officer_model")
class OfficerModel (@PrimaryKey(autoGenerate = true)
                    val id: Int = 100000,
                    @ColumnInfo (name = "name")
                    val name: String,
                    @ColumnInfo (name = "major")
                    val major: String,
                    @ColumnInfo (name = "birthDate")
                    val birthDate:String,
                    @ColumnInfo (name = "rank")
                    val rank: String
)