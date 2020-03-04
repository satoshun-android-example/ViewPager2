package com.github.satoshun.example.motion

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.MaterialMotionChildFragBinding
import com.github.satoshun.example.databinding.MaterialMotionFragBinding
import com.google.android.material.transition.MaterialFadeThrough

class MaterialMotionFragment : Fragment(R.layout.material_motion_frag) {
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val binding = MaterialMotionFragBinding.bind(view)

    with(binding.viewpager) {
      adapter = ChildAdapter(this@MaterialMotionFragment)
    }

    var count = 1
    binding.button.setOnClickListener {
      binding.viewpager.setCurrentItem(count, false)
      count += 1
    }
  }
}

class ChildAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
  override fun getItemCount(): Int = 5

  override fun createFragment(position: Int): Fragment {
    return when (position % 5) {
      else -> Child1Fragment().apply { count = position }
    }
  }
}

class Child1Fragment : Fragment(R.layout.material_motion_child_frag) {
  var count = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    exitTransition = MaterialFadeThrough.create(requireContext()).apply { duration = 10000L }
    enterTransition = MaterialFadeThrough.create(requireContext()).apply { duration = 10000L }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val binding = MaterialMotionChildFragBinding.bind(view)

    binding.button.text = count.toString()

    binding.image.isVisible = count % 2 == 0
  }
}
