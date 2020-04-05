package com.grdj.quecomemoshoy.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.grdj.quecomemoshoy.model.fullrecipe.Hits


class CustomView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0) : View(context, attributeSet, defStyleAttr){

    lateinit var item: Hits

    companion object {
        fun getItem(customView: CustomView): Hits{
            return customView.item
        }

        fun setItem(customView: CustomView, value: Hits){
            customView.item = value
        }
    }
}