package com.github.satoshun.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.github.satoshun.example.databinding.Viewpager2ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPager2Activity : AppCompatActivity() {

  private lateinit var binding: Viewpager2ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.viewpager2_activity_main)

    binding.viewpager.offscreenPageLimit = 3
    binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    binding.viewpager.setPageTransformer(MarginPageTransformer(300)) // TODO px

    //    binding.viewpager.adapter = FragmentStateAdapterExample(this)
//    binding.viewpager.adapter = ViewPagerAdapterExample()
    binding.viewpager.adapter = GroupieAdapterExample()

    val tabLayout: TabLayout = findViewById(R.id.tab)
    val mediator = TabLayoutMediator(tabLayout, binding.viewpager) { tab: TabLayout.Tab, position: Int ->
      tab.text = "test $position"
    }
    mediator.attach()
  }
}
