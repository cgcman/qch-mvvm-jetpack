package com.grdj.quecomemoshoy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_food_type.view.*
import android.content.Context
import com.bumptech.glide.Glide
import com.grdj.quecomemoshoy.model.RecipeModel

class SwiperAdapter (val list:ArrayList<RecipeModel>, private val itemClickListener: (Int) -> Unit) : RecyclerView.Adapter<SwiperAdapter.MyViewHolder>(){

    lateinit var _cntx: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwiperAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(com.grdj.quecomemoshoy.R.layout.swipe_list_item, parent, false)
        _cntx = parent.context
        return SwiperAdapter.MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SwiperAdapter.MyViewHolder, position: Int) {
        holder.bindItems( list[position] , _cntx, itemClickListener)
    }

    public fun getItems(): ArrayList<RecipeModel> {
        return list
    }

    public fun removeTopItem() {
        list.removeAt(0)
        notifyDataSetChanged()
    }

    fun updateList(newList: ArrayList<RecipeModel>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: RecipeModel, context:Context, itemClickListener:(Int)->Unit) {
            itemView.title.text=item.title
            val url = item.image

            Glide
                .with(context)
                .load(url)
                .centerCrop()
                .into(itemView.image)

            itemView.setOnClickListener { itemClickListener(adapterPosition) }
        }
    }
}