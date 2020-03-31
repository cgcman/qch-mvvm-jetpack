package com.grdj.quecomemoshoy.utils

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.grdj.quecomemoshoy.R

class Utils {
    companion object{
        fun getProgressDrawable(context: Context): CircularProgressDrawable {
            return CircularProgressDrawable(context).apply {
                strokeWidth = 5f
                centerRadius= 30f
                start()
            }
        }

        fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable) {
            val options = RequestOptions()
                .placeholder(progressDrawable)
                .error(R.mipmap.ic_launcher)

            Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(uri)
                .into(this)
        }

        @JvmStatic @BindingAdapter("android:imageUrl")
        fun loadImage(view: ImageView, url: String?) {
            view.loadImage(url, getProgressDrawable(view.context))
        }
    }
}