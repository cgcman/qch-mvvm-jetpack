package com.grdj.quecomemoshoy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class FoodTypeModel (
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String?,

    @ColumnInfo(name = "image")
    @SerializedName("image")
    val image: Int?
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}