package com.example.dbofficer.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class OfficerModel (var id: Int? = null,
                         var name: String?="",
                         var major: String?="",
                         var birthDate:String?="",
                         var rank: String?="") : Parcelable
