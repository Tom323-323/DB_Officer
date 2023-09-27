package com.example.dbofficer.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "officer_model")
class OfficerModel (@PrimaryKey(autoGenerate = true)
                    val id: Int = 100000,
                    @ColumnInfo
                    val name: String,
                    @ColumnInfo
                    val secondName: String,
                    @ColumnInfo
                    val major: String,
                    @ColumnInfo
                    val birthDate:String,
                    @ColumnInfo
                    val rank: String
)