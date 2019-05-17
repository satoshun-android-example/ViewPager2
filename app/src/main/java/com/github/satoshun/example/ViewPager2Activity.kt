package com.github.satoshun.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPager2Activity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.viewpager2_activity_main)

    val viewPager: ViewPager2 = findViewById(R.id.viewpager)
    viewPager.adapter = FragmentStateAdapterExample(this)

    val tabLayout: TabLayout = findViewById(R.id.tab)
    val mediator = TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, position: Int ->
      tab.text = "test $position"
    }
    mediator.attach()

//    viewPager.adapter = ViewPagerAdapterExample()
//    viewPager.adapter = GroupieAdapterExample()
  }
}
