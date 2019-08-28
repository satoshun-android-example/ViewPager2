package com.github.satoshun.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewpager2.widget.ViewPager2
import com.github.satoshun.example.databinding.Viewpager2ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPager2Activity : AppCompatActivity() {

  private lateinit var binding: Viewpager2ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.viewpager2_activity_main)

    binding.viewpager.adapter = FragmentStateAdapterExample(this)

    val tabLayout: TabLayout = findViewById(R.id.tab)
    val mediator = TabLayoutMediator(tabLayout, binding.viewpager) { tab: TabLayout.Tab, position: Int ->
      tab.text = "test $position"
    }
    mediator.attach()

//    viewPager.adapter = ViewPagerAdapterExample()
//    viewPager.adapter = GroupieAdapterExample()
  }
}
