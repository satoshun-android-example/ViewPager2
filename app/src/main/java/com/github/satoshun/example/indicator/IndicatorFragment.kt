package com.github.satoshun.example.indicator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.satoshun.example.GroupieAdapterExample2
import com.github.satoshun.example.databinding.IndicatorFragBinding
import com.google.android.material.tabs.TabLayoutMediator

class IndicatorFragment : Fragment() {
  private lateinit var binding: IndicatorFragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = IndicatorFragBinding.inflate(
      inflater,
      container,
      false
    )
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    with(binding.viewpager) {
      offscreenPageLimit = 3
      adapter = GroupieAdapterExample2()
    }

    val mediator = TabLayoutMediator(
      binding.tab,
      binding.viewpager,
      TabLayoutMediator.OnConfigureTabCallback { tab, position ->
      })
    mediator.attach()
  }
}
