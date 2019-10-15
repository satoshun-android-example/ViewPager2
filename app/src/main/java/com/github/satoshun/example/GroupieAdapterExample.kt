package com.github.satoshun.example

import android.widget.TextView
import androidx.viewpager2.widget.CompositePageTransformer
import com.github.satoshun.example.databinding.ViewpagerItemBinding
import com.github.satoshun.example.databinding.ViewpagerScaleItemBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import com.xwray.groupie.databinding.BindableItem
import kotlin.math.abs

class GroupieAdapterExample : GroupAdapter<GroupieViewHolder>() {
  init {
    addAll(
      listOf(
        SampleItem(android.R.color.holo_green_light),
        SampleItem(android.R.color.holo_red_dark),
        SampleItem(android.R.color.holo_blue_bright),
        SampleItem(android.R.color.holo_purple),
        SampleItem(android.R.color.holo_orange_light)
      )
    )
  }
}

class SampleItem(private val colorId: Int) : Item<GroupieViewHolder>() {
  override fun getLayout(): Int = R.layout.item_page

  override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    viewHolder.itemView.findViewById<TextView>(R.id.title).text = colorId.toString()
    viewHolder.itemView.setBackgroundResource(colorId)
  }
}

class ViewPagerAdapter : GroupAdapter<GroupieViewHolder>() {
  init {
    add(ViewPagerItem())
    add(ViewPagerScaleItem())
  }
}

class ViewPagerItem : BindableItem<ViewpagerItemBinding>() {
  override fun getLayout(): Int = R.layout.viewpager_item

  override fun bind(binding: ViewpagerItemBinding, position: Int) = with(binding) {
    viewpager.offscreenPageLimit = 2

    val pageMarginPx = root.context.resources.getDimensionPixelOffset(R.dimen.page_margin)
    val offsetPx = root.context.resources.getDimensionPixelOffset(R.dimen.offset)
    viewpager.setPageTransformer { page, position ->
      val offset = position * (2 * offsetPx + pageMarginPx)
      page.translationX = -offset
    }
    viewpager.adapter = GroupieAdapterExample()
  }
}

class ViewPagerScaleItem : BindableItem<ViewpagerScaleItemBinding>() {
  override fun getLayout(): Int = R.layout.viewpager_scale_item

  override fun bind(binding: ViewpagerScaleItemBinding, position: Int) = with(binding) {
    viewpager.offscreenPageLimit = 2

    val pageMarginPx = root.context.resources.getDimensionPixelOffset(R.dimen.page_margin2)
    val offsetPx = root.context.resources.getDimensionPixelOffset(R.dimen.offset2)
    viewpager.setPageTransformer(CompositePageTransformer().apply {
      addTransformer { page, position ->
        val offset = position * (2 * offsetPx + pageMarginPx)
        page.translationX = -offset
      }

      addTransformer { page, position ->
        val scale = 1 - (abs(position) / 6)
        page.scaleX = scale
        page.scaleY = scale
      }
    })

    viewpager.adapter = GroupieAdapterExample2()
  }
}

class GroupieAdapterExample2 : GroupAdapter<GroupieViewHolder>() {
  init {
    addAll(
      listOf(
        SampleItem2(android.R.color.holo_green_light),
        SampleItem2(android.R.color.holo_red_dark),
        SampleItem2(android.R.color.holo_blue_bright),
        SampleItem2(android.R.color.holo_purple),
        SampleItem2(android.R.color.holo_orange_light)
      )
    )
  }
}

class SampleItem2(private val colorId: Int) : Item<GroupieViewHolder>() {
  override fun getLayout(): Int = R.layout.item_page2

  override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    viewHolder.itemView.findViewById<TextView>(R.id.title).text = colorId.toString()
    viewHolder.itemView.setBackgroundResource(colorId)
  }
}
