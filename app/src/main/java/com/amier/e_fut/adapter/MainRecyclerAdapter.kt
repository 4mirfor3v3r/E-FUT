package com.amier.e_fut.adapter

import com.amier.e_fut.R
import com.amier.e_fut.model.Items
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.main_item_rv.view.*

class MainRecyclerAdapter(val list:Items):Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.main_item_rv
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.main_item_image.setBackgroundResource(list.image!!)
        viewHolder.itemView.main_item_tv_title.text = list.title
        viewHolder.itemView.main_item_tv_subtitle.text = list.subtitle
        viewHolder.itemView.main_item_rating.rating = list.rating ?: 0f
    }
}