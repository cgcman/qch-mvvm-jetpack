package com.grdj.quecomemoshoy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class RecipeModel (
    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title:String?,

    @ColumnInfo(name = "image")
    @SerializedName("image")
    var image:String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}