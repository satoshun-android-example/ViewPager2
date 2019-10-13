package com.github.satoshun.example.infinite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.satoshun.example.databinding.InfiniteFragBinding

class InfiniteFragment : Fragment() {
  private lateinit var binding: InfiniteFragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = InfiniteFragBinding.inflate(
      inflater,
      container,
      false
    )
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    with(binding.viewpager) {
      val infiniteAdapter = InfiniteAdapter(itemData = mockAdapterData)
      adapter = infiniteAdapter
      val center = Int.MAX_VALUE / 2
      val start = center - (center % mockAdapterData.size)
      setCurrentItem(start, false)
    }
  }
}

// alphabet a-c
private val mockAdapterData = (0..2).map {
  Data(title = ('a' + it).toString())
}
