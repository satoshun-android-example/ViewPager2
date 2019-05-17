package com.github.satoshun.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class ViewPager2Activity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.viewpager2_activity_main)

    val viewPager: ViewPager2 = findViewById(R.id.viewpager)
    viewPager.adapter = FragmentStateAdapterExample(this)

//    viewPager.adapter = ViewPagerAdapterExample()
//    viewPager.adapter = GroupieAdapterExample()
  }
}
