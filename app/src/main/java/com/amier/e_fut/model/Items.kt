package com.amier.e_fut.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Items(
    var title:String ?=null,
    var subtitle:String ?=null,
    var rating: Float?=null,
    var image:Int?=null
):Parcelable