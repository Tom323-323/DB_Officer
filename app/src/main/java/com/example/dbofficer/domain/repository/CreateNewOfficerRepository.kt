package com.example.dbofficer.domain.repository

import android.content.Context
import com.example.dbofficer.domain.model.OfficerModel

interface CreateNewOfficerRepository {
    fun createOfficer(officerModel: OfficerModel, context: Context)

}