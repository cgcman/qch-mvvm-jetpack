package com.grdj.quecomemoshoy.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class FoodTypeModel (
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String?,

    @ColumnInfo(name = "image")
    @SerializedName("image")
    val image: Int?
): Parcelable {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}