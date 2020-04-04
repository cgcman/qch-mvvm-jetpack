package com.grdj.quecomemoshoy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.grdj.quecomemoshoy.R
import com.grdj.quecomemoshoy.databinding.ItemFoodTypeBinding
import com.grdj.quecomemoshoy.model.FoodTypeModel
import com.grdj.quecomemoshoy.view.MainFragmentDirections
import kotlinx.android.synthetic.main.item_food_type.view.*

class FoodTypeAdapter(val list:ArrayList<FoodTypeModel>): RecyclerView.Adapter<FoodTypeAdapter.MyViewHolder>(), FoodTypeClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemFoodTypeBinding>(inflater, R.layout.item_food_type, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    fun updateList(newList: ArrayList<FoodTypeModel>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.item.foodTypeModel = list[position]
        holder.item.listener = this
    }

    override fun onItemClicked(v: View) {
        val action = MainFragmentDirections.actionMainToFoodList()
        action.query = v.title.text.toString()
        Navigation.findNavController(v).navigate(action)
    }

    class MyViewHolder(var item: ItemFoodTypeBinding): RecyclerView.ViewHolder(item.root)
}