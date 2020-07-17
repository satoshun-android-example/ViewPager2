package com.github.satoshun.example.fake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.github.satoshun.example.FragmentStateAdapterExample
import com.github.satoshun.example.databinding.FakeDragFragBinding
import kotlinx.coroutines.*

class FakeDragFragment : Fragment() {
  private lateinit var binding: FakeDragFragBinding

  private var job: Job? = null

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

      registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
          super.onPageSelected(position)
          if (position >= 1) {
            job?.cancel()
          }
        }
      })
    }

    job = lifecycleScope.launch {
      delay(500)

      binding.viewPager.beginFakeDrag()
      repeat(10) {
        binding.viewPager.fakeDragBy(-10f)
        delay(16)
      }
      binding.viewPager.fakeDragBy(20f)

      // This line is for testing purpose
      delay(5000)

      binding.viewPager.endFakeDrag()
      delay(100)
    }

    lifecycleScope.launch {
      delay(1000)

      // endFakeDrag before setting to currentItem
      if (binding.viewPager.isFakeDragging) {
        binding.viewPager.endFakeDrag()
        job?.cancel()
      }
      binding.viewPager.currentItem = 3
    }

    println("Hit: ${view.findViewTreeLifecycleOwner()}")
  }
}
