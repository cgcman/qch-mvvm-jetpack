package com.grdj.quecomemoshoy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.databinding.ItemFoodTypeBinding
import com.grdj.quecomemoshoy.model.FoodTypeModel

class foodTypeAdapter(val list:ArrayList<FoodTypeModel>): RecyclerView.Adapter<foodTypeAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemFoodTypeBinding>(inflater, R.layout.item_food_type, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = list.size

    fun updateList(newList: ArrayList<FoodTypeModel>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.item.foodTypeModel = list[position]
    }

    class MyViewHolder(var item: ItemFoodTypeBinding): RecyclerView.ViewHolder(item.root)
}