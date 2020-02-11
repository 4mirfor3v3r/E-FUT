package com.amier.e_fut.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amier.e_fut.R
import com.amier.e_fut.model.Items
import kotlinx.android.synthetic.main.main_item_rv.view.*

class MainRVAdapter(context: Context, val list:List<Items>):RecyclerView.Adapter<MainRVAdapter.VHolder>() {
    class VHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val x = LayoutInflater.from(parent.context).inflate(R.layout.main_item_rv,parent,false)
        return VHolder(x)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.itemView.main_item_image.setBackgroundResource(list[position].image!!)
        holder.itemView.main_item_tv_title.text = list[position].title
        holder.itemView.main_item_tv_subtitle.text = list[position].subtitle
        holder.itemView.main_item_rating.rating = list[position].rating ?: 0f
    }
}