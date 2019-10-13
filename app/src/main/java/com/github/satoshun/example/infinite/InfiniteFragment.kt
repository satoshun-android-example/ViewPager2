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
      val infiniteAdapter = InfiniteAdapter(data = mockAdapterData)
      adapter = infiniteAdapter
    }
  }
}

private val mockAdapterData = (0..26).map {
  InfiniteData(title = ('a' + it).toString())
}
