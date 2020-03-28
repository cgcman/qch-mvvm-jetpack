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
        //val itemView = LayoutInflater.from(parent.context).inflate(R.layout.food_list_item, parent, false)
        val itemView = DataBindingUtil.inflate<FoodListItemBinding>(inflater, R.layout.food_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.itemView = list[position]
    }

    fun updateList(newList: ArrayList<RecipeModel>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onItemClicked(v: View) {
        //Navigation.findNavController(v).navigate(R.id.action_main_to_foodList)
    }

    class MyViewHolder(var itemView: FoodListItemBinding): RecyclerView.ViewHolder(itemView.root)
}