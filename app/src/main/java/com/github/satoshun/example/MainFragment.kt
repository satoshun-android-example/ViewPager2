package com.github.satoshun.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.github.satoshun.example.databinding.MainFragBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
  private lateinit var binding: MainFragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = MainFragBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.viewpager.offscreenPageLimit = 3
    binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

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
