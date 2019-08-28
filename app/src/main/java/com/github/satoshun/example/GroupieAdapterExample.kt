package com.github.satoshun.example

import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.github.satoshun.example.databinding.ViewpagerItemBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import com.xwray.groupie.databinding.BindableItem

internal class GroupieAdapterExample : GroupAdapter<ViewHolder>() {
  init {
    addAll(
      listOf(
        SampleItem(android.R.color.white),
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

internal class ViewPagerAdapter : GroupAdapter<ViewHolder>() {
  init {
    add(ViewPagerItem())
  }
}

internal class ViewPagerItem : BindableItem<ViewpagerItemBinding>() {
  override fun getLayout(): Int = R.layout.viewpager_item

  override fun bind(binding: ViewpagerItemBinding, position: Int) = with(binding) {
    viewpager.offscreenPageLimit = 3
    viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    val pageMarginPx = root.context.resources.getDimensionPixelOffset(R.dimen.pageMargin)
    val offsetPx = root.context.resources.getDimensionPixelOffset(R.dimen.offset)
    viewpager.setPageTransformer { page, position ->
      val offset = position * (2 * offsetPx + pageMarginPx)
      page.translationX = -offset
    }
    viewpager.adapter = GroupieAdapterExample()
  }
}
