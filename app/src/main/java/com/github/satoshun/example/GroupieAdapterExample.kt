package com.github.satoshun.example

import android.widget.TextView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder

internal class GroupieAdapterExample : GroupAdapter<ViewHolder>() {
  init {
    addAll(
      listOf(
        SampleItem(android.R.color.black),
        SampleItem(android.R.color.holo_red_dark),
        SampleItem(android.R.color.holo_blue_bright),
        SampleItem(android.R.color.holo_purple),
        SampleItem(android.R.color.holo_orange_light)
      )
    )
  }
}

internal class SampleItem(private val colorId: Int) : Item<ViewHolder>() {
  override fun getLayout(): Int = R.layout.item_page

  override fun bind(viewHolder: ViewHolder, position: Int) {
    viewHolder.itemView.findViewById<TextView>(R.id.title).text = colorId.toString()
    viewHolder.itemView.setBackgroundResource(colorId)
  }
}
