package com.grdj.quecomemoshoy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.databinding.FoodListItemBinding
import com.grdj.quecomemoshoy.model.RecipeModel

class FoodListAdapter(val list:ArrayList<RecipeModel>): RecyclerView.Adapter<FoodListAdapter.MyViewHolder>(), FoodTypeClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val itemView = DataBindingUtil.inflate<FoodListItemBinding>(inflater, R.layout.food_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    fun updateList(newList: ArrayList<RecipeModel>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.item.recipeModel= list[position]
        holder.item.listener = this
    }

    override fun onItemClicked(v: View) {
        Navigation.findNavController(v).navigate(R.id.action_foodList_to_details)
    }

    class MyViewHolder(var item: FoodListItemBinding): RecyclerView.ViewHolder(item.root)
}