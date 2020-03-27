package com.grdj.quecomemoshoy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.model.RecipeModel
import kotlinx.android.synthetic.main.food_list_item.view.*

class FoodListAdapter(val list:ArrayList<RecipeModel>): RecyclerView.Adapter<FoodListAdapter.MyViewHolder>() {
    lateinit var _cntx: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.food_list_item, parent, false)
        _cntx = parent.context
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(list[position], _cntx)
    }

    fun updateList(newList: ArrayList<RecipeModel>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: RecipeModel, context: Context) {
            itemView.title.text=item.title
            val url = item.image

            Glide
                .with(context)
                .load(url)
                .centerCrop()
                //.placeholder(R.drawable.progress_spin)
                .into(itemView.food_image)
        }
    }
}