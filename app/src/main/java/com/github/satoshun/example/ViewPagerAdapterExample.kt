package com.github.satoshun.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_page.view.*

internal class ViewPagerAdapterExample : RecyclerView.Adapter<ViewHolderExample>() {
  private val colors = intArrayOf(
    android.R.color.black,
    android.R.color.holo_red_light,
    android.R.color.holo_blue_dark,
    android.R.color.holo_purple
  )

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderExample =
    ViewHolderExample(
      LayoutInflater.from(parent.context).inflate(
        R.layout.item_page,
        parent,
        false
      )
    )

  override fun getItemCount(): Int = colors.size

  override fun onBindViewHolder(
    holder: ViewHolderExample,
    position: Int
  ) {
    with(holder.itemView) {
      title.text = "item $position"
      container.setBackgroundResource(colors[position])
    }
  }
}

internal class ViewHolderExample(
  itemView: View
) : RecyclerView.ViewHolder(itemView)
