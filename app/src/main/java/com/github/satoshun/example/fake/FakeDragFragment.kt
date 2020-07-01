package com.github.satoshun.example.fake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.satoshun.example.FragmentStateAdapterExample
import com.github.satoshun.example.databinding.FakeDragFragBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class FakeDragFragment : Fragment() {
  private lateinit var binding: FakeDragFragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FakeDragFragBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    with(binding.viewPager) {
      offscreenPageLimit = 5
      adapter = FragmentStateAdapterExample(this@FakeDragFragment)
    }

    lifecycleScope.launch {
      delay(500)

      repeat(10) {
        binding.viewPager.beginFakeDrag()
        (0..10).forEach {
          binding.viewPager.fakeDragBy(-10f)
          delay(16)
        }
        binding.viewPager.fakeDragBy(20f)
        binding.viewPager.endFakeDrag()
        delay(100)
      }
//      delay(1000)
//
//      delay(1000)
//      binding.viewPager.fakeDragBy(-100f)
//      delay(1000)
//      binding.viewPager.fakeDragBy(0f)
//      delay(1000)
////      binding.viewPager.fakeDragBy(0f)
////      }
//      binding.viewPager.endFakeDrag()
    }
  }
}
