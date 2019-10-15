package com.github.satoshun.example.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.satoshun.example.GroupieAdapterExample
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.TabLayoutFragBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutFragment : Fragment() {
  private lateinit var binding: TabLayoutFragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = TabLayoutFragBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.viewpager.offscreenPageLimit = 3

    val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.page_margin)
    val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)
    binding.viewpager.setPageTransformer { page, position ->
      val offset = position * (2 * offsetPx + pageMarginPx)
      page.translationX = -offset
    }

    //    binding.viewpager.adapter = FragmentStateAdapterExample(this)
//    binding.viewpager.adapter = ViewPagerAdapterExample()
    binding.viewpager.adapter = GroupieAdapterExample()

    val mediator = TabLayoutMediator(binding.tab, binding.viewpager) { tab: TabLayout.Tab, position: Int ->
      tab.text = "test $position"
    }
    mediator.attach()
  }
}
