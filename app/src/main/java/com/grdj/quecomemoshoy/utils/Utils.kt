package com.grdj.quecomemoshoy.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.model.fullrecipe.Hits

class Utils {
    companion object{
        fun getProgressDrawable(context: Context): CircularProgressDrawable {
            return CircularProgressDrawable(context).apply {
                strokeWidth = 5f
                centerRadius= 30f
                start()
            }
        }

        fun ImageView.loadImage(uri: String?) {
            val options = RequestOptions()
                .placeholder(getProgressDrawable(context))

            Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(uri)
                .into(this)
        }
    }
}