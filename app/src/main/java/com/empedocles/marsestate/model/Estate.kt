package com.empedocles.marsestate.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Estate(
    @SerializedName("price")
    val estatePrice: Int,
    @SerializedName("id")
    val estateId: String,
    @SerializedName("type")
    val estateType: String,
    @SerializedName("img_src")
    val imageUrl: String
) : Parcelable