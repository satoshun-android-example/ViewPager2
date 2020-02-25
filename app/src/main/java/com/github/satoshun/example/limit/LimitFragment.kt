package com.github.satoshun.example.limit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.LimitFragBinding

class LimitFragment : Fragment(R.layout.limit_frag) {
  private lateinit var binding: LimitFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = LimitFragBinding.bind(view)

    binding.viewpager.adapter = LimitFragmentAdapter(this)
  }
}

private class LimitFragmentAdapter(
  fragment: Fragment
) : FragmentStateAdapter(fragment) {
  override fun getItemCount(): Int = 2

  override fun createFragment(position: Int): Fragment =
    when (position) {
      0 -> Test1Fragment()
      else -> Test2Fragment()
    }
}

class Test1Fragment : Fragment() {
  init {
    println("Test1Fragment")
  }
}

class Test2Fragment : Fragment() {
  init {
    println("Test2Fragment")
  }
}
