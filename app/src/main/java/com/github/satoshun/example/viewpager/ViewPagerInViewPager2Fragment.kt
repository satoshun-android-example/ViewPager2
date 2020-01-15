package com.github.satoshun.example.viewpager

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.github.satoshun.example.GroupieAdapterExample2
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.ViewpagerInViewpager2Binding
import com.github.satoshun.example.databinding.ViewpagerInViewpager2ChildBinding

class ViewPagerInViewPager2Fragment : Fragment(R.layout.viewpager_in_viewpager2) {
  private lateinit var binding: ViewpagerInViewpager2Binding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = ViewpagerInViewpager2Binding.bind(view)

    binding.viewpager.adapter = ViewPagerInViewPager2FragmentAdapter(this)
  }
}

class ViewPagerInViewPager2FragmentAdapter(
  fragment: Fragment
) : FragmentStatePagerAdapter(fragment.parentFragmentManager) {
  override fun getItem(position: Int): Fragment = ViewPagerInViewPager2ChildFragment().apply {
    count = position
  }

  override fun getCount(): Int = 3
}

class ViewPagerInViewPager2ChildFragment : Fragment(R.layout.viewpager_in_viewpager2_child) {
  var count: Int = 0

  private lateinit var binding: ViewpagerInViewpager2ChildBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = ViewpagerInViewpager2ChildBinding.bind(view)
    binding.viewpager.adapter = GroupieAdapterExample2()

    binding.root.setBackgroundColor(
      when (count) {
        1 -> Color.BLACK
        2 -> Color.BLUE
        else -> Color.DKGRAY
      }
    )
  }
}
